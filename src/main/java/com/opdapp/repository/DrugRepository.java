package com.opdapp.repository;

import com.opdapp.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends CrudRepository<Drug,Long> {
    Drug getDrugByDrugId(final long drugId);
}
