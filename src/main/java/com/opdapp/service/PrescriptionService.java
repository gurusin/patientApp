package com.opdapp.service;

import com.opdapp.dto.PrescriptionDTO;
import com.opdapp.model.Prescription;

import java.util.List;

public interface PrescriptionService {
    void savePrescription(final PrescriptionDTO dto);

    List<PrescriptionDTO> loadPrescriptions(long l);
}
