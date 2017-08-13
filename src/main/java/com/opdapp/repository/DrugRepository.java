package com.opdapp.repository;

import com.opdapp.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends CrudRepository<Drug,Long> {
    Drug getDrugByDrugId(final long drugId);

    List<Drug> findByBrandNameLike(final String brandName);
}
