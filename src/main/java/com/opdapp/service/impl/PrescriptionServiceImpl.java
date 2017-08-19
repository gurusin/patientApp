package com.opdapp.service.impl;

import com.opdapp.dto.PrescriptionDTO;
import com.opdapp.dto.PrescriptionDetailDTO;
import com.opdapp.model.Patient;
import com.opdapp.model.Prescription;
import com.opdapp.model.PrescriptionDetail;
import com.opdapp.repository.PatientRepository;
import com.opdapp.repository.PrescriptionRepository;
import com.opdapp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<PrescriptionDTO> loadPrescriptions(long l) {
        final Patient p = patientRepository.findOne(l);
        final List<PrescriptionDTO> dtoList = new ArrayList<>();
        for(final Prescription obj :prescriptionRepository.findPrescriptionByPatient(p))
        {
            final PrescriptionDTO dto = new PrescriptionDTO();
            dto.setNotes(obj.getNotes());
            dto.setSymptoms(obj.getSymptoms());
            dto.setDiagnosis(obj.getDiagnosis());
            dto.setPrescriptionDate(obj.getDate());
            dto.setPrescriptionDate(obj.getDate());

            final List<PrescriptionDetailDTO> prescriptionDetailDTOS = new ArrayList<PrescriptionDetailDTO>();
            for (PrescriptionDetail prescriptionDetail : obj.getPrescriptionDetails()) {
                final PrescriptionDetailDTO prescriptionDetailDTO = new PrescriptionDetailDTO();
                prescriptionDetailDTO.setAmount(prescriptionDetail.getAmount());
                prescriptionDetailDTO.setDrug(prescriptionDetail.getDrug());
                prescriptionDetailDTO.setDuration(prescriptionDetail.getDuration());
                prescriptionDetailDTO.setFrequency(prescriptionDetail.getFrequency());
                prescriptionDetailDTO.setStrength(prescriptionDetail.getStrength());
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
    public void savePrescription(PrescriptionDTO dto) {

        final Prescription prescription = createPrescription(dto);
        prescription.setPrescriptionDetails(createDetails(dto,prescription));
        prescriptionRepository.save(prescription);
    }

    private Set<PrescriptionDetail> createDetails(final PrescriptionDTO dto, final Prescription p)
    {
        final Set<PrescriptionDetail> set = new HashSet<>();
        for (final PrescriptionDetail obj:dto.getPrescriptionDetails())
        {
            obj.setPrescription(p);
            set.add(obj);
        }
        return set;

    }
    private Prescription createPrescription(final PrescriptionDTO dto)
    {
        final Prescription prescription = new Prescription();
        prescription.setPatient(patientRepository.findOne(dto.getPatientId()));
        prescription.setDiagnosis(dto.getDiagnosis());
        prescription.setNotes(dto.getNotes());
        prescription.setSymptoms(dto.getSymptoms());
        prescription.setDate(new Date(System.currentTimeMillis()));
        return prescription;
    }


}
