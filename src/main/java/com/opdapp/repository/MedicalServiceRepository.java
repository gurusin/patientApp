package com.opdapp.repository;

import com.opdapp.model.MedicalServiceItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalServiceRepository extends CrudRepository<MedicalServiceItem, Long> {
    List<MedicalServiceItem> findAll();
}
