package com.opdapp.repository;

import com.opdapp.model.BaseDrug;
import com.opdapp.model.Strength;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrengthRepository extends CrudRepository<Strength, Long> {
    List<Strength> findAll();
}
