package com.opdapp.service;

import com.opdapp.dto.PrescriptionDTO;
import com.opdapp.dto.SavedPrescriptionDTO;
import com.opdapp.dto.prescription.PrescriptionSearchDTO;
import com.opdapp.model.Prescription;

import java.util.Date;
import java.util.List;

/**
 * Provides methods for saving and loading prescription data
 *
 */
public interface PrescriptionService
{

    /**
     * Creates the new Prescription in the database
     * @param dto
     * @return
     */
    Prescription savePrescription(final PrescriptionDTO dto);

    /**
     * Returns the List of PrescriptionDTO for the given patient
     * @param l
     * @return
     */
    List<PrescriptionDTO> loadPrescriptionsForPatient(long l);

    /**
     * Returns the List of Prescriptions  issued for the given date
     * @param date
     * @return
     */
    List<Prescription> loadPrescriptionsByDate(final Date date);

    /**
     * Returns the Prescription for the given Id
     * @param id
     * @return
     */
    Prescription get(String id);

    /**
     * Returns a list of prescriptions according to the search criteria.
     * @param prescriptionSearchDTO
     * @return
     */
    List<Prescription> findPrescriptions(PrescriptionSearchDTO prescriptionSearchDTO);
}
