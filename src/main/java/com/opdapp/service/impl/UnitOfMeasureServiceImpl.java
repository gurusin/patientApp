package com.opdapp.service.impl;

import com.opdapp.model.Strength;
import com.opdapp.model.StrengthUnit;
import com.opdapp.model.UnitOfMeasure;
import com.opdapp.repository.StrengthRepository;
import com.opdapp.repository.StrengthUnitRepository;
import com.opdapp.repository.UnitOfMeasureRespository;
import com.opdapp.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    private UnitOfMeasureRespository unitOfMeasureRespository;

    @Autowired
    private StrengthUnitRepository strengthUnitRepository;

    @Autowired
    private StrengthRepository strengthRepository;


    @Override
    public List<UnitOfMeasure> loadUnitOfMeasures(){
        return unitOfMeasureRespository.findAll();
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure){
        return  unitOfMeasureRespository.save(unitOfMeasure);
    }

    @Override
    public Iterable<StrengthUnit> getAllStrengthUnits()
    {
        return strengthUnitRepository.findAll();
    }

    @Override
    public void saveStrength(Strength strength) {
        StrengthUnit unit = strengthUnitRepository.findOne
                (strength.getStrengthUnit().getUnitId());
        strength.setStrengthUnit(unit);
        strengthRepository.save(strength);
    }
}
