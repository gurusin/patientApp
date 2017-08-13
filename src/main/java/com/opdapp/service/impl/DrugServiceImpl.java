package com.opdapp.service.impl;

import com.opdapp.model.Drug;
import com.opdapp.model.PrescribableDrug;
import com.opdapp.repository.DrugRepository;
import com.opdapp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public PrescribableDrug getByDrugId(long drugId) {
        PrescribableDrug prescribableDrug = new PrescribableDrug();
        List<String> doseFrequency = new ArrayList<String>();
        doseFrequency.add("1 time tDaily");
        doseFrequency.add("2 times tDaily");
        doseFrequency.add("3 times tDaily");
        doseFrequency.add("4 times tDaily");
        doseFrequency.add("6 times tDaily");
        doseFrequency.add("8 times tDaily");
        doseFrequency.add("12 times tDaily");
        doseFrequency.add("24 times tDaily");
        doseFrequency.add("1 time Weekly");
        doseFrequency.add("2 times Weekly");
        doseFrequency.add("3 times Weekly");
        doseFrequency.add("Once Every other day");
        doseFrequency.add("1 time Monthly");
        doseFrequency.add("1 times Weekly");
        doseFrequency.add("1 times Weekly");


        prescribableDrug.setDoseFrequency(doseFrequency);

        List<String> durationunit = new ArrayList<String>();
        durationunit.add("Days");
        durationunit.add("Hours");
        durationunit.add("Weeks");
        durationunit.add("Months");


        prescribableDrug.setDurationUnit(durationunit);

        Drug drug = drugRepository.getDrugByDrugId(drugId);
        prescribableDrug.setDrug(drug);

        List<String> strenghts = new ArrayList<String>();
        strenghts.add("10 mg");
        strenghts.add("5 mg");
        strenghts.add("20 mg");
        strenghts.add("10 mg");

        prescribableDrug.setStrengths(strenghts);

        return prescribableDrug;
    }
}
