package com.opdapp.repository;

import com.opdapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UnitOfMeasureRespository extends CrudRepository<UnitOfMeasure, Long> {

    List<UnitOfMeasure> findAll();
}
