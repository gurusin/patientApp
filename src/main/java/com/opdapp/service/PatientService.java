package com.opdapp.service;

import com.opdapp.dto.PatientSearchDTO;
import com.opdapp.model.Patient;

import java.util.List;

public interface PatientService
{
    Patient save(Patient patient);

    List<Patient> findByNIC(final String nic);

    Patient getByNIC(String nic);

    Patient getByPatientId(long patId);

    List<Patient> findByPhoneNoLike(String s);

    Patient getByPhoneNo(String phoneNo);

    List<Patient> loadPatients(String name);

    List<PatientSearchDTO> findByName(String name);
}
