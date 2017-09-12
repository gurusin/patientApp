package com.opdapp.repository;

import com.opdapp.model.MedicalServItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalServiceRepository extends CrudRepository<MedicalServItem, Long> {
    List<MedicalServItem> findAll();
}
