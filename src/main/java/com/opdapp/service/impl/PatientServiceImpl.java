package com.opdapp.service.impl;

import com.opdapp.dto.PatientSearchDTO;
import com.opdapp.model.Patient;
import com.opdapp.repository.PatientRepository;
import com.opdapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Patient> byId = patientRepository.findById(patId);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
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
    public List<Patient> loadPatients(String name)
    {
        name = name+"%";
        List<Patient> byFirstnameLikeOrLastnameLike = patientRepository.findByFirstnameLikeOrLastnameLike(name, name);
        return byFirstnameLikeOrLastnameLike;
    }

    @Override
    public List<PatientSearchDTO> findByName(String name) {

        List<Patient> patList = patientRepository.findByFirstnameLikeOrLastnameLike(name, name);
        List<PatientSearchDTO> dto = new ArrayList<>(patList.size());
        patList.forEach(x ->{
            dto.add(x.toSearchByNameDTO());
        });
        return dto;
    }

}
