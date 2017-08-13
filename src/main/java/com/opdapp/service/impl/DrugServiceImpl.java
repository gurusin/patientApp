package com.opdapp.service.impl;

import com.opdapp.model.Drug;
import com.opdapp.model.PrescribableDrug;
import com.opdapp.model.SearchedDrug;
import com.opdapp.repository.DrugRepository;
import com.opdapp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public List<SearchedDrug> getByBrandName(String brandName){
        List<Drug> searchedDrug = drugRepository.findByBrandNameLike(brandName);
        //todo search in bse drug and add
        return getSearchedDrug(searchedDrug);
    }

    private List<SearchedDrug> getSearchedDrug(List<Drug> drugs){
        List<SearchedDrug> searchedDrugList = new ArrayList<SearchedDrug>();
        for (Drug drug:drugs){
            SearchedDrug searchedDrug = new SearchedDrug();
            searchedDrug.setBrandName(drug.getBrandName());
            searchedDrug.setDrugId(drug.getDrugId());
            searchedDrugList.add(searchedDrug);
        }
        return searchedDrugList;
    }
}
