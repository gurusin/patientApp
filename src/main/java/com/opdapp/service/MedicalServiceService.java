package com.opdapp.service;

import com.opdapp.model.MedicalServiceItem;

import java.util.List;

public interface MedicalServiceService {
    List<MedicalServiceItem> loadAllMedicalService();

    MedicalServiceItem save(MedicalServiceItem medicalServiceItem);
}
