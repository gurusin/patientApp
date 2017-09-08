package com.opdapp.service;
import com.opdapp.model.UnitOfMeasure;

import java.util.List;

public interface UnitOfMeasureService {
    List<UnitOfMeasure> loadUnitOfMeasures();

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure);
}
