package com.opdapp.repository;

import com.opdapp.model.Drug;
import com.opdapp.model.DrugPackage;
import com.opdapp.model.Strength;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugPackageRepository extends CrudRepository<DrugPackage, Integer> {
    List<DrugPackage> getDrugPackageByDrug(Drug drug);

    List<DrugPackage> findAll();
}
