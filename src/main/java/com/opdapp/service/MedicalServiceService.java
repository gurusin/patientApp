package com.opdapp.service;

import com.opdapp.model.MedicalServItem;

import java.util.List;

public interface MedicalServiceService {
    List<MedicalServItem> loadAllMedicalService();

    MedicalServItem save(MedicalServItem medicalServiceItem);
}
