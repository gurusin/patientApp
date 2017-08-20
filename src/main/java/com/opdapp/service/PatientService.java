package com.opdapp.service;

import com.opdapp.model.Patient;

import java.util.List;

/**
 * Created by sudarshana on 07/08/2017.
 */
public interface PatientService
{
    Patient save(Patient patient);

    List<Patient> findByNIC(final String nic);

    Patient getByNIC(String nic);

    Patient getByPatientId(long patId);

    List<Patient> findByPhoneNoLike(String s);

    Patient getByPhoneNo(String phoneNo);

    List<Patient> loadPatients();
}
