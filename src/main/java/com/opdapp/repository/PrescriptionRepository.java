package com.opdapp.repository;

import com.opdapp.model.Patient;
import com.opdapp.model.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription,Long> {

    List<Prescription> findPrescriptionByPatient(final Patient patient);
}
