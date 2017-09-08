package com.opdapp.repository;

import com.opdapp.model.BaseDrug;
import com.opdapp.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDrugRepository extends CrudRepository<BaseDrug, Integer> {
    List<BaseDrug> findAll();
}
