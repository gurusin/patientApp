package com.opdapp.service.impl;

import com.opdapp.model.MedicalServItem;
import com.opdapp.repository.MedicalServiceRepository;
import com.opdapp.repository.ProductTypeRepository;
import com.opdapp.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {

    @Autowired
    private MedicalServiceRepository medicalServiceRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<MedicalServItem> loadAllMedicalService() {
        List list =  medicalServiceRepository.findAll();
        return list;
    }

    @Override
    public MedicalServItem save(MedicalServItem medicalServiceItem) {
        medicalServiceItem.setProductType(
                productTypeRepository.findOne(medicalServiceItem.getProductType().getItemTypeId()));
        return medicalServiceRepository.save(medicalServiceItem);
    }
}
