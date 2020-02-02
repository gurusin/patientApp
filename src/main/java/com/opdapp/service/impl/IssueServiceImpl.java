package com.opdapp.service.impl;

import com.opdapp.dto.issue.MakeIssue;
import com.opdapp.dto.issue.MakeIssueDetailDTO;
import com.opdapp.model.*;
import com.opdapp.repository.*;
import com.opdapp.service.IssueService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private ServiceIssueItemRepository serviceIssueItemRepository;



    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PrescriptionIssueDetailRepository prescriptionIssueDetailRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public IssueNote findIssue(long issueNo) {
        return issueNoteRepository.findById(issueNo).get();
    }

    @Override
    public void migrateNotes() {
        for (final IssueNote note : issueNoteRepository.findAll())
        {
            if (note.getPatient() == null)
            {
                // Find the patient and set
            }
        }
    }

    @Override
    public Iterable<IssueNote> findIssueForPatient(long patientId) {
        final Patient patient = patientRepository.findById(patientId).get();
        return issueNoteRepository.findByPatient(patient);
    }

    @Override
    public MakeIssue createIssueForPrescription(String prescriptionId) {
        final Prescription prescription = prescriptionRepository.findById(Long.parseLong(prescriptionId)).get();
        final Map<Long, PrescriptionDetail> detailIds = new HashMap<>();
        for (final PrescriptionDetail detail : prescription.getPrescriptionDetails()) {
            detailIds.put(detail.getId(), detail);
        }
        Iterable<PrescriptionIssueDetail> issuedItems = prescriptionIssueDetailRepository.
                findByPrescriptionDetailIdIn(detailIds.keySet());

        final Map<Long, PrescriptionIssueDetail> issuedItemMap = new HashMap<>();
        for (final PrescriptionIssueDetail obj : issuedItems) {
            issuedItemMap.put(obj.getPrescriptionDetailId(), obj);
        }

        final Set<MakeIssueDetailDTO> makeIssueDetailDTOList = new HashSet<>();
        for (final PrescriptionDetail detail : prescription.getPrescriptionDetails()) {
            final MakeIssueDetailDTO dto = new MakeIssueDetailDTO();
            final PrescriptionIssueDetail obj = issuedItemMap.get(detail.getId());
            if (obj == null) {
                // Item not issued yet Create new MakeIssue Details.
                dto.setDrugPackage(detail.getDrugPackage());
                double prescribedQty = detail.getPrescribedQty();
                if (prescribedQty == 0)
                {
                    // Auto correction in cased it's missed during saving
                    prescribedQty = getPrescribedQty(detail);
                }
                dto.setPrescribedQty(prescribedQty);
                dto.setPrescriptionDetailId(detail.getId());
                dto.setDuration(detail.getDuration() + "," + detail.getIntervalUnit());
                dto.setFrequency(detail.getFrequency().getValue());
                dto.setDose(detail.getAmount());
            } else {
                // Item is already issued
                dto.setDrugPackage(detail.getDrugPackage());
                dto.setPrescribedQty(obj.getPrescribedAmount());
                dto.setPrescriptionDetailId(obj.getPrescriptionDetailId());
                dto.setDuration(detail.getDuration() + "," + detail.getIntervalUnit());
                dto.setFrequency(detail.getFrequency().getValue());
                dto.setDose(detail.getAmount());
                dto.setIssuedQty(obj.getIssuedAmount());
            }
            makeIssueDetailDTOList.add(dto);
        }
        final MakeIssue makeIssue = new MakeIssue();
        makeIssue.setDateOfIssue(new Date());
        makeIssue.setPatient(prescription.getPatient());
        makeIssue.setDetails(makeIssueDetailDTOList);
        makeIssue.setPrescriptionId(prescription.getId());
        // Services items are added only when a prescription is issued for the
        // first time.
        if (prescription.getPrescriptionStatus() == PrescriptionStatus.INITIAL)
        {
            makeIssue.setServiceItems(prescription.getMedicalServices());
        }

        return makeIssue;
    }

    private double getPrescribedQty(final PrescriptionDetail prescDet) {
        double returnQty = 0;
        // Like 2 pills, 3 pills  etc.
        final DoseFrequency freq = prescDet.getFrequency();
        final double noOfTimes = freq.getNoofDoses();
        final double noOfItemsPerOneTake = prescDet.getAmount();
        final double duration = prescDet.getDuration();
        double durationInDays = 0;

        // Amount is calculated only for oral application
        if (!prescDet.getMeal().equals(Meal.ORAL))
        {
            return 1;
        }

        switch (prescDet.getIntervalUnit().toUpperCase()) {
            case "DAYS": {
                durationInDays = duration;
                break;
            }
            case "WEEKS": {
                durationInDays = duration * 7;
                break;
            }
            case "MONTHS": {
                durationInDays = duration * 30;
                break;
            }
            default: {
                durationInDays = 1;
            }
        }
        if (prescDet.getDrugPackage().getDrugPackageContentType() == DrugPackageContentType.CREAM) {
            returnQty = 1;

        } else {
            returnQty = noOfTimes * durationInDays * noOfItemsPerOneTake;
        }

        return returnQty;
    }

    @Override
    public void makeIssue(final MakeIssue issue) {

        // Check whether this is a service only issue
        if (issue.getPrescriptionId() < 1) {
            makeServiceOnlyIssue(issue);
            return;
        }
        final Map<Long, MakeIssueDetailDTO> issueMap = mapIssues(issue);
        final IssueNote note = new IssueNote();
        final Set<IssueNoteDetails> detailsSet = new HashSet<IssueNoteDetails>();
        note.setIssueDate(new java.sql.Date(issue.getDateOfIssue().getTime()));

        Map<Long, PrescriptionIssueDetail> issuedItems = getIssuedItemMap(issueMap.keySet());
        boolean completedPrescription = true;
        boolean newPrescription = true;

        for (final MakeIssueDetailDTO dto : issueMap.values()) {
            PrescriptionIssueDetail issueDetail = issuedItems.get(dto.getPrescriptionDetailId());

            if (issueDetail == null) {
                issueDetail = new PrescriptionIssueDetail();
                issueDetail.setPrescriptionDetailId(dto.getPrescriptionDetailId());
                issueDetail.setPrescribedAmount(dto.getPrescribedQty());
                issueDetail.setBalanceAmount(dto.getPrescribedQty() - dto.getCurrentIssuedQty());
                issueDetail.setIssuedAmount(dto.getCurrentIssuedQty());
                prescriptionIssueDetailRepository.save(issueDetail);
                completedPrescription = completedPrescription && issueDetail.getBalanceAmount() < 1;

            } else {
                newPrescription = false;
                issueDetail.setBalanceAmount(dto.getIssuedQty() - dto.getCurrentIssuedQty());
                issueDetail.setIssuedAmount(issueDetail.getIssuedAmount() + dto.getCurrentIssuedQty());
                prescriptionIssueDetailRepository.save(issueDetail);
                completedPrescription = completedPrescription && issueDetail.getBalanceAmount() < 1;
            }

            // Update stock in DrugPackage
            final DrugPackage drugPackage = drugPackageRepository.findById(dto.getDrugPackage().getDrugPackageId()).get();
            drugPackage.setQuantity(drugPackage.getQuantity() - dto.getCurrentIssuedQty());
            drugPackageRepository.save(drugPackage);

            final IssueNoteDetails detail = new IssueNoteDetails();
            detail.setIssueNote(note);
            detail.setDrugPackage(dto.getDrugPackage());
            detail.setBuyingQuantity(dto.getCurrentIssuedQty());
            detail.setPrescribedQty(dto.getPrescribedQty());
            detail.setIssueInformation("");
            detailsSet.add(detail);
        }
        note.setIssueNoteDetails(detailsSet);
        // Update the prescription
        final Prescription prescription = prescriptionRepository.findById(issue.getPrescriptionId()).get();
        if (completedPrescription) {
            prescription.setPrescriptionStatus(PrescriptionStatus.COMPLETED);
        } else {
            prescription.setPrescriptionStatus(PrescriptionStatus.PARTIALLY_ISSED);
        }
        if (prescription != null)
        {
            note.setPatient(prescription.getPatient());
            note.setPrescriptionId(prescription.getId());
        }

        // Saving the services
        if (newPrescription) {
            saveServices(issue, prescription,note);
        }
        issueNoteRepository.save(note);
        prescriptionRepository.save(prescription);
    }

    private void makeServiceOnlyIssue(MakeIssue issue) {
        final IssueNote note = new IssueNote();
        note.setIssueDate(new java.sql.Date(issue.getDateOfIssue().getTime()));
        note.setPatient(issue.getPatient()); //
        // TODO : Load patient for session if this object is returned;
        final Set<IssueNoteServiceItem> serviceItems = new HashSet<>();
        for (final PrescriptionServiceItem serviceItem : issue.getServiceItems()) {

            final IssueNoteServiceItem item = new IssueNoteServiceItem();
            item.setIssueNote(note);
            // Please load this if this object is returned
            item.setMedicalServItem(serviceItem.getMedicalServItem());
            item.setFee(serviceItem.getFee());
            item.setExternalId(serviceItem.getExternalRef());
            serviceItems.add(item);
        }
        note.setIssueNoteServiceItems(serviceItems);
        issueNoteRepository.save(note);
    }

    /**
     * Saves the services in the database. This should happen only in the event of the first time
     * issue is made in the prescription
     *
     * @param issue
     * @param prescription
     */
    private void saveServices(MakeIssue issue, Prescription prescription, final IssueNote note) {
        final Set<IssueNoteServiceItem> serviceItems = new HashSet<>();
        for (final PrescriptionServiceItem serviceItem : issue.getServiceItems()) {
            final IssueNoteServiceItem item = new IssueNoteServiceItem();
            item.setIssueNote(note);
            // Please load this if this object is returned
            item.setMedicalServItem(serviceItem.getMedicalServItem());
            item.setFee(serviceItem.getFee());
            item.setExternalId(serviceItem.getExternalRef());
            serviceItems.add(item);
        }
        note.setIssueNoteServiceItems(serviceItems);
    }

    /**
     * Return a map of Issued Items for this PO items
     *
     * @param keys
     * @return
     */
    private Map<Long, PrescriptionIssueDetail> getIssuedItemMap(Set<Long> keys) {
        Iterable<PrescriptionIssueDetail> issuedItems = prescriptionIssueDetailRepository.
                findByPrescriptionDetailIdIn(keys);

        final Map<Long, PrescriptionIssueDetail> issuedItemMap = new HashMap<>();
        for (final PrescriptionIssueDetail obj : issuedItems) {
            issuedItemMap.put(obj.getPrescriptionDetailId(), obj);
        }
        return issuedItemMap;
    }

    private void updateStock(final DrugPackage drugPackage, final double qty) {
        final double currentQty = drugPackage.getQuantity();
        drugPackage.setQuantity((int) (currentQty - qty));
        drugPackageRepository.save(drugPackage);
    }

    private Map<Long, MakeIssueDetailDTO> mapIssues(final MakeIssue issue) {
        final Map<Long, MakeIssueDetailDTO> returnMap = new HashMap<>();
        for (final MakeIssueDetailDTO dto : issue.getDetails()) {
            returnMap.put(dto.getPrescriptionDetailId(), dto);
        }
        return returnMap;
    }
}
