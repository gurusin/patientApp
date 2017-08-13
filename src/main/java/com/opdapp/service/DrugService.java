package com.opdapp.service;

import com.opdapp.model.PrescribableDrug;

public interface DrugService {
    public PrescribableDrug getByDrugId(long patId);
}
