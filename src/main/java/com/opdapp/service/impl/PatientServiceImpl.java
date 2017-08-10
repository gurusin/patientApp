package com.opdapp.service.impl;

import com.opdapp.model.Patient;
import com.opdapp.repository.PatientRepository;
import com.opdapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sudarshana on 07/08/2017.
 **/

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient save(final Patient patient)
    {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findByNIC(String nic) {
        return patientRepository.findByNicLike(nic);
    }
}
