package com.opdapp.repository;


import com.opdapp.model.DoseFrequency;
import com.opdapp.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrequencyRepository extends CrudRepository<DoseFrequency, Long> {
    List<DoseFrequency> findAll();
}
