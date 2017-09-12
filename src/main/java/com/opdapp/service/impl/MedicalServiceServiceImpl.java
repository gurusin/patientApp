package com.opdapp.service.impl;

import com.opdapp.model.MedicalServiceItem;
import com.opdapp.repository.MedicalServiceRepository;
import com.opdapp.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {

    @Autowired
    MedicalServiceRepository medicalServiceRepository;

    @Override
    public List<MedicalServiceItem> loadAllMedicalService() {
        List list =  medicalServiceRepository.findAll();
        return list;
    }

    @Override
    public MedicalServiceItem save(MedicalServiceItem medicalServiceItem) {
        return medicalServiceRepository.save(medicalServiceItem);
    }
}
