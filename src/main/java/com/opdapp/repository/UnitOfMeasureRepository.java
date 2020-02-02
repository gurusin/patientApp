package com.opdapp.repository;

import com.opdapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Integer> {

    UnitOfMeasure getUnitOfMeasuresByUnitOfMeasureLike(String unitOfMeasure);
}
