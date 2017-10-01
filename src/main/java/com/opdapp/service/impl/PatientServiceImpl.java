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
        final Patient patient1 =  patientRepository.save(patient);
        patient1.calculateAge();
        return patient1;
    }

    @Override
    public List<Patient> findByNIC(String nic) {
        return patientRepository.findByNicLike(nic);
    }

    @Override
    public Patient getByNIC(String nic) {
        return patientRepository.getPatientByNic(nic);
    }

    @Override
    public Patient getByPatientId(long patId) {
        return patientRepository.findOne(patId);
    }

    @Override
    public List<Patient> findByPhoneNoLike(String phoneNo) {
        return patientRepository.findByPhoneLike(phoneNo);

    }

    @Override
    public Patient getByPhoneNo(String phoneNo) {
        final List<Patient> list = patientRepository.findByPhone(phoneNo);
        if (list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Patient> loadPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByName(String name) {
        return patientRepository.findByFirstnameLikeOrLastnameLike(name,name);
    }
}
