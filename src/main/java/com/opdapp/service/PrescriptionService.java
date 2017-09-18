package com.opdapp.service;

import com.opdapp.dto.PrescriptionDTO;
import com.opdapp.dto.SavedPrescriptionDTO;
import com.opdapp.model.Prescription;

import java.util.Date;
import java.util.List;

public interface PrescriptionService {
     SavedPrescriptionDTO savePrescription(final PrescriptionDTO dto);

    List<PrescriptionDTO> loadPrescriptionsForPatient(long l);

    List<SavedPrescriptionDTO> loadPrescriptionsByDate(final Date date);

    Prescription get(String id);
}
