package com.opdapp.service.impl;

import com.opdapp.model.*;
import com.opdapp.repository.DrugPackageRepository;
import com.opdapp.repository.DrugRepository;
import com.opdapp.repository.FrequencyRepository;
import com.opdapp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private FrequencyRepository frequencyRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    public PrescribableDrug getByDrugId(long drugId) {
        PrescribableDrug prescribableDrug = new PrescribableDrug();
        List<DoseFrequency> doseFrequencies = frequencyRepository.findAll();
        List<String> doseFrequency = new ArrayList<String>();

        for (DoseFrequency doseFrequencyObj : doseFrequencies) {
            StringBuilder freStr = new StringBuilder();
            freStr.append(doseFrequencyObj.getTimeUnit());
            freStr.append(" times ");
            freStr.append(doseFrequencyObj.getTimeUnit());
            doseFrequency.add(freStr.toString());
        }

        prescribableDrug.setDoseFrequency(doseFrequency);

        List<String> durationunit = new ArrayList<String>();
        durationunit.add("Days");
        durationunit.add("Hours");
        durationunit.add("Weeks");
        durationunit.add("Months");


        prescribableDrug.setDurationUnit(durationunit);

        Drug drug = drugRepository.findOne((int)drugId);
        prescribableDrug.setDrug(drug);

        List<DrugPackage> strengthList = drugPackageRepository.getDrugPackageByDrug(drug);
        List<String> strenghts = new ArrayList<String>();
        for (DrugPackage strength : strengthList) {
            StringBuilder strStr = new StringBuilder();
            strStr.append(strength.getStrength().getStrengthAmount());
            strStr.append(" ");
            strStr.append(strength.getStrength().getStrengthUnit().getUnitName());
            strenghts.add(strStr.toString());
        }

        prescribableDrug.setStrengths(strenghts);

        return prescribableDrug;
    }

    public List<SearchedDrug> getByBrandName(String brandName) {
        List<Drug> searchedDrug = drugRepository.findByBrandNameLike(brandName);
        //todo search in bse drug and add
        return getSearchedDrug(searchedDrug);
    }

    private List<SearchedDrug> getSearchedDrug(List<Drug> drugs) {
        List<SearchedDrug> searchedDrugList = new ArrayList<SearchedDrug>();
        for (Drug drug : drugs) {
            SearchedDrug searchedDrug = new SearchedDrug();
            searchedDrug.setBrandName(drug.getBrandName());
            searchedDrug.setDrugId(drug.getDrugId());
            searchedDrugList.add(searchedDrug);
        }
        return searchedDrugList;
    }
}
