package com.opdapp.service;

import com.opdapp.model.PrescribableDrug;
import com.opdapp.model.SearchedDrug;

import java.util.List;

public interface DrugService {
    PrescribableDrug getByDrugId(long patId);

    List<SearchedDrug> getByBrandName(String brandName);
}
