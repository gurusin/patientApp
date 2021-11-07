package com.opdapp.repository.dental;

import com.opdapp.model.Patient;
import com.opdapp.model.dental.PatTreatmentItem;
import com.opdapp.model.dental.TreatmentItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatTreatmentItemRepository extends CrudRepository<PatTreatmentItem, Long> {

   List<PatTreatmentItem> findPatTreatmentItemByPatient(final Patient pat);
   int countPatTreatmentItemByTreatmentItem(TreatmentItem item);
}
