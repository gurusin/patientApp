package com.opdapp.service.impl;

import com.opdapp.dto.*;
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
    public List<PrescriptionDTO> loadPrescriptions(long l) {
        final Patient p = patientRepository.findOne(l);
        final List<PrescriptionDTO> dtoList = new ArrayList<>();
        for (final Prescription obj : prescriptionRepository.findPrescriptionByPatient(p)) {
            final PrescriptionDTO dto = new PrescriptionDTO();
            dto.setNotes(obj.getNotes());
            dto.setSymptoms(obj.getSymptoms());
            dto.setDiagnosis(obj.getDiagnosis());
            dto.setPrescriptionDate(obj.getDate());

            final List<PrescriptionDetailDTO> prescriptionDetailDTOS = new ArrayList<PrescriptionDetailDTO>();
            for (PrescriptionDetail prescriptionDetail : obj.getPrescriptionDetails()) {
                final PrescriptionDetailDTO prescriptionDetailDTO = new PrescriptionDetailDTO();
                prescriptionDetailDTO.setAmount(prescriptionDetail.getAmount());
                prescriptionDetailDTO.setDrug(prescriptionDetail.getDrug());
                prescriptionDetailDTO.setDuration(prescriptionDetail.getDuration());
                prescriptionDetailDTO.setFrequency(prescriptionDetail.getFrequency());
                prescriptionDetailDTO.setStrength(prescriptionDetail.getStrength().toString());
                prescriptionDetailDTO.setIntervalUnit(prescriptionDetail.getIntervalUnit());
                prescriptionDetailDTO.setMeal(prescriptionDetail.getMeal());
                prescriptionDetailDTOS.add(prescriptionDetailDTO);
            }
            dto.setPrescriptionDetailDTOS(prescriptionDetailDTOS);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<SavedPrescriptionDTO> loadPrescriptionsByDate(final java.util.Date date){
        java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
        List<Prescription> loadedPrecs = prescriptionRepository.findPrescriptionByDate(sqlDate);
        List<Long> prescriptionIds = new ArrayList<Long>();

        for (Prescription presc: loadedPrecs){
            prescriptionIds.add(presc.getId());
        }
        List<IssueNote> issueNotes = issueNoteRepository.findIssueNoteByExternalIdIn(prescriptionIds);
        Map<Long,List<IssueNote>> issueNoteMap = new HashMap<Long, List<IssueNote>>();
        for (IssueNote issueNote: issueNotes) {
            List<IssueNote> issueNotesList = null;
            if (issueNoteMap.containsKey(issueNote.getExternalId())) {
                issueNotesList = issueNoteMap.get(issueNote.getExternalId());
            }else {
                issueNotesList = new ArrayList<IssueNote>();
            }
            issueNotesList.add(issueNote);
            issueNoteMap.put(issueNote.getExternalId(), issueNotesList);
        }
        List<SavedPrescriptionDTO> savedPrescriptionDTOS = new ArrayList<SavedPrescriptionDTO>();

        for (Prescription presc: loadedPrecs){
            if (issueNoteMap.containsKey(presc.getId())) {
                List<IssueNote> issueNoteperPrec = issueNoteMap.get(presc.getId());
                for (IssueNote in : issueNoteperPrec) {
                    SavedPrescriptionDTO savedPrescriptionDTO = getSavedPrescriptionDTO(in, presc);
                    savedPrescriptionDTOS.add(savedPrescriptionDTO);
                }
            } else {
                SavedPrescriptionDTO savedPrescriptionDTO = getSavedPrescriptionDTO(null, presc);
                savedPrescriptionDTOS.add(savedPrescriptionDTO);
            }
        }
        return  savedPrescriptionDTOS;

    }

    @Override
    public SavedPrescriptionDTO savePrescription(PrescriptionDTO dto) {

        final Prescription prescription = createPrescription(dto);
        prescription.setPrescriptionDetails(createDetails(dto, prescription));
        prescription.setMedicalServices(createMedicalServices(dto,prescription));
        Prescription savedPrescription = prescriptionRepository.save(prescription);

        // Saving the auto created issue note
        final IssueNote note = saveIssueNote(savedPrescription);
        SavedPrescriptionDTO savedPrescriptionDTO = getSavedPrescriptionDTO(note, savedPrescription);
        return savedPrescriptionDTO;

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

    private SavedPrescriptionDTO getSavedPrescriptionDTO(IssueNote note, Prescription prescription){
        final SavedPrescriptionDTO savedPrescriptionDTO = new SavedPrescriptionDTO();
        savedPrescriptionDTO.setIssueNote(note);
        populateDTo(savedPrescriptionDTO, prescription);
        return savedPrescriptionDTO;
    }

    private IssueDTO getIssueDTO(IssueNote issueNote) {
        IssueDTO issueNoteDTO = new IssueDTO();
        issueNoteDTO.setIssueDate(issueNote.getIssueDate());
        issueNoteDTO.setIssueStatus(issueNote.getIssueStatus());
        issueNoteDTO.setPaymentMethod(issueNote.getPaymentMethod());
        issueNoteDTO.setIssueNo(issueNote.getIssueNote());
        issueNoteDTO.setDetails(getIssueDetailsDTO(issueNote.getIssueNoteDetails()));
        return issueNoteDTO;
    }

    private List<IssueDetailDTO> getIssueDetailsDTO(Set<IssueNoteDetails> issueNoteDetails) {
        List<IssueDetailDTO> issueDetailDTOS = new ArrayList<IssueDetailDTO>();
        for (IssueNoteDetails issueNoteDetail : issueNoteDetails) {
            IssueDetailDTO issueDetailDTO = new IssueDetailDTO();
            issueDetailDTO.setItemId(issueNoteDetail.getDrugPackage().getDrugPackageId());
            issueDetailDTO.setQuantity(issueNoteDetail.getBuyingQuantity());
            issueDetailDTO.setItemPrice(issueNoteDetail.getDrugPackage().getUnitPrice());
            issueDetailDTO.setDescription(issueNoteDetail.getDrugPackage().getDrug().getBrandName() + ", " + issueNoteDetail.getDrugPackage().getStrength().getStrengthAmount() + issueNoteDetail.getDrugPackage().getStrength().getStrengthAmount());
            issueDetailDTOS.add(issueDetailDTO);
        }
        return issueDetailDTOS;
    }

    private void populateDTo(final SavedPrescriptionDTO dto, final Prescription prescription) {
        final PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setDiagnosis(prescription.getDiagnosis());
        prescriptionDTO.setPrescriptionDetailDTOS(convertToDetailDTO(prescription));
        prescriptionDTO.setPrescriptionDate(prescription.getDate());
        final Patient patient = prescription.getPatient();
        if (patient != null)
        {
            prescriptionDTO.setPatientName(prescription.getPatient().getFirstname() + prescription.getPatient().getLastname());
        }
        dto.setPrescriptionDTO(prescriptionDTO);
    }

    private List<PrescriptionDetailDTO> convertToDetailDTO(Prescription prescription) {
        final List<PrescriptionDetailDTO> dtoSet = new ArrayList<>();
        for (final PrescriptionDetail detail : prescription.getPrescriptionDetails()) {
            final PrescriptionDetailDTO dto = new PrescriptionDetailDTO();
            // TODO: Create detached objects to avoid the stack overflow
            dto.setDrug(detail.getDrug());
            dto.setAmount(detail.getAmount());
            dto.setStrength(detail.getStrength().getStrengthAmount() + "," + detail.getStrength().getStrengthUnit());
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

    private void addServices(Prescription prescription, final IssueNote issueNote)
    {

    }

    private DrugPackage findDrugPackage(final PrescriptionDetail prescriptionDetail) {
        return drugPackageRepository.findByDrugAndStrength(prescriptionDetail.getDrug(),
                prescriptionDetail.getStrength());
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
        for (final PrescriptionDetail obj : dto.getPrescriptionDetails()) {
            obj.setPrescription(p);
            set.add(obj);
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
