package com.opdapp.service;

import com.opdapp.dto.issue.DailyIncomeReport;
import com.opdapp.model.MedicalServItem;

import java.util.Date;
import java.util.List;

public interface MedicalServiceService
{
    List<MedicalServItem> loadAllMedicalService();

    MedicalServItem save(MedicalServItem medicalServiceItem);

    DailyIncomeReport getDailyIncome(DailyIncomeReport report);
}
