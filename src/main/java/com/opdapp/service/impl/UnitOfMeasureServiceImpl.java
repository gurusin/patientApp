package com.opdapp.service.impl;

import com.opdapp.model.UnitOfMeasure;
import com.opdapp.repository.UnitOfMeasureRespository;
import com.opdapp.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    UnitOfMeasureRespository unitOfMeasureRespository;

    @Override
    public List<UnitOfMeasure> loadUnitOfMeasures(){
        return unitOfMeasureRespository.findAll();
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure){
        return  unitOfMeasureRespository.save(unitOfMeasure);
    }
}
