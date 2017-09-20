package com.opdapp.service.impl;

import com.opdapp.dto.*;
import com.opdapp.dto.prescription.PrescriptionSearchDTO;
import com.opdapp.model.*;
import com.opdapp.repository.*;
import com.opdapp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    @Autowired
    private FrequencyRepository frequencyRepository;

    @Autowired
    private MedicalServiceRepository medicalServiceRepository;

    @Override
    public List<PrescriptionDTO> loadPrescriptionsForPatient(long l) {
        final Patient p = patientRepository.findOne(l);
        final List<PrescriptionDTO> dtoList = new ArrayList<>();
        for (final Prescription obj : prescriptionRepository.findPrescriptionByPatient(p)) {
            final PrescriptionDTO dto = new PrescriptionDTO();
            dto.setPrescriptionId(obj.getId());
            dto.setNotes(obj.getNotes());
            dto.setSymptoms(obj.getSymptoms());
            dto.setDiagnosis(obj.getDiagnosis());
            dto.setPrescriptionDate(obj.getDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<Prescription> findPrescriptions(PrescriptionSearchDTO prescriptionSearchDTO) {
        final Set<PrescriptionStatus> statSet = new HashSet<>();
        if(prescriptionSearchDTO.isCompleted()){statSet.add(PrescriptionStatus.COMPLETED);}
        if(prescriptionSearchDTO.isPartCompleted()){statSet.add(PrescriptionStatus.PARTIALLY_ISSED);}
        if(prescriptionSearchDTO.isInitial()){statSet.add(PrescriptionStatus.INITIAL);}
        if (prescriptionSearchDTO.isAll())
        {
            return prescriptionRepository.findPrescriptionByDateBetween(
                    prescriptionSearchDTO.getFromDate(), prescriptionSearchDTO.getToDate());
        }
        return prescriptionRepository.findPrescriptionByDateBetweenAndPrescriptionStatusIn(
                prescriptionSearchDTO.getFromDate(), prescriptionSearchDTO.getToDate(),statSet);
    }

    @Override
    public Prescription get(String id) {
        return prescriptionRepository.findOne(Long.parseLong(id));
    }

    @Override
    public List<Prescription> loadPrescriptionsByDate(final java.util.Date date){
        java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
        return prescriptionRepository.findPrescriptionByDate(sqlDate);
    }

    @Override
    public Prescription savePrescription(PrescriptionDTO dto) {

        final Prescription prescription = createPrescription(dto);
        prescription.setPrescriptionDetails(createDetails(dto, prescription));
        prescription.setMedicalServices(createMedicalServices(dto,prescription));
        prescription.setPrescriptionStatus(PrescriptionStatus.INITIAL);
        return prescriptionRepository.save(prescription);
    }

    private Set<PrescriptionServiceItem> createMedicalServices(PrescriptionDTO dto, Prescription prescription) {
       final Set<PrescriptionServiceItem> returnSet = new HashSet<>();
       for (final MedicalServItem item : dto.getMedicalServices())
       {
           final PrescriptionServiceItem obj = new PrescriptionServiceItem();
           obj.setFee(item.getUnitPrice());
           obj.setPrescription(prescription);
           obj.setMedicalServItem(medicalServiceRepository.findOne(item.getItemId()));
           obj.setExternalRef(item.getExternalRef());
           returnSet.add(obj);
       }
       return returnSet;
    }

    private List<PrescriptionDetailDTO> convertToDetailDTO(Prescription prescription) {
        final List<PrescriptionDetailDTO> dtoSet = new ArrayList<>();
        for (final PrescriptionDetail detail : prescription.getPrescriptionDetails()) {
            final PrescriptionDetailDTO dto = new PrescriptionDetailDTO();
            dto.setAmount(detail.getAmount());
            dtoSet.add(dto);
        }
        return dtoSet;
    }

    private IssueNote saveIssueNote(Prescription prescription) {
        IssueNote issueNote = new IssueNote();
        issueNote.setPatient(prescription.getPatient());
        issueNote.setIssueDate(prescription.getDate());
        issueNote.setIssueStatus(IssueStatus.CREATED);
        issueNote.setPaymentMethod(PaymentMethod.CASH);
        issueNote.setExternalId(prescription.getId());
        issueNote.setIssueNoteDetails(createIssueDetails(prescription, issueNote));
        issueNote.setIssueNoteServiceItems(createIssueNoteServiceItems(issueNote,prescription));
        return issueNoteRepository.save(issueNote);
    }

    private Set<IssueNoteServiceItem> createIssueNoteServiceItems(IssueNote issueNote, Prescription prescription) {
       final Set<IssueNoteServiceItem> returnSet = new HashSet<>();
       for (final PrescriptionServiceItem item : prescription.getMedicalServices())
       {
           final IssueNoteServiceItem obj = new IssueNoteServiceItem();
           obj.setIssueNote(issueNote);
           obj.setFee(item.getFee());
           obj.setMedicalServItem(item.getMedicalServItem());
           obj.setExternalId(item.getExternalRef());
           returnSet.add(obj);
       }
       return returnSet;
    }

    private Set<IssueNoteDetails> createIssueDetails(Prescription prescription, final IssueNote issueNote) {
        Set<IssueNoteDetails> detailsSet = new HashSet<IssueNoteDetails>();
        for (final PrescriptionDetail prescDet : prescription.getPrescriptionDetails()) {
            IssueNoteDetails issueNoteDetail = new IssueNoteDetails();
            issueNoteDetail.setIssueNote(issueNote);
            double buyingQty = getBuyingQty(prescDet);
            issueNoteDetail.setPrescribedQty(buyingQty);
            issueNoteDetail.setBalanceQty(buyingQty);
            issueNoteDetail.setDrugPackage(findDrugPackage(prescDet));
            detailsSet.add(issueNoteDetail);
        }
        return detailsSet;
    }


    private DrugPackage findDrugPackage(final PrescriptionDetail prescriptionDetail) {
        return prescriptionDetail.getDrugPackage();
    }

    private double getBuyingQty(final PrescriptionDetail prescDet) {
        double returnQty = 0;
        // Like 2 pills, 3 pills  etc.
        final DoseFrequency freq = frequencyRepository.findOne(prescDet.getFrequency().getDoseFrequencyId());
        final double noOfTimes = freq.getNoofDoses();
        final double noOfItemsPerOneTake = prescDet.getAmount();
        final double duration = prescDet.getDuration();
        double durationInDays = 0;
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
            }
        }
        returnQty = noOfTimes * durationInDays * noOfItemsPerOneTake;
        return returnQty;
    }

    private Set<PrescriptionDetail> createDetails(final PrescriptionDTO dto, final Prescription p) {
        final Set<PrescriptionDetail> set = new HashSet<>();
        for (final PrescriptionDetailDTO obj : dto.getPrescriptionDetailDTOS()) {
            final PrescriptionDetail detail = new PrescriptionDetail();
            detail.setPrescription(p);
            detail.setDrugPackage(drugPackageRepository.findOne(obj.getDrugPackageId()));
            detail.setFrequency(frequencyRepository.findOne(obj.getDoseFrequencyId()));
            detail.setMeal(obj.getMeal());
            detail.setDuration(obj.getDuration());
            detail.setAmount(obj.getAmount());
            detail.setIntervalUnit(obj.getIntervalUnit());
            set.add(detail);
        }
        return set;

    }

    private Prescription createPrescription(final PrescriptionDTO dto) {
        final Prescription prescription = new Prescription();
        prescription.setPatient(patientRepository.findOne(dto.getPatientId()));
        prescription.setDiagnosis(dto.getDiagnosis());
        prescription.setNotes(dto.getNotes());
        prescription.setSymptoms(dto.getSymptoms());
        prescription.setDate(new Date(System.currentTimeMillis()));
        return prescription;
    }


}
