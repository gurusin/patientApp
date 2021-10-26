package com.opdapp.repository.dental;

import com.opdapp.model.BaseDrug;
import com.opdapp.model.dental.TreatmentItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentItemRepository extends CrudRepository<TreatmentItem, Long> {
}
