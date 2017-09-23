package com.opdapp.service;
import com.opdapp.model.Strength;
import com.opdapp.model.StrengthUnit;
import com.opdapp.model.UnitOfMeasure;

import java.util.List;

public interface UnitOfMeasureService {
    List<UnitOfMeasure> loadUnitOfMeasures();

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure);

    Iterable<StrengthUnit> getAllStrengthUnits();

    /**
     * Saves the strength
     * @param strength
     */
    void saveStrength(Strength strength);
}
