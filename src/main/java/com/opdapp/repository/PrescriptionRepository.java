package com.opdapp.repository;

import com.opdapp.model.Patient;
import com.opdapp.model.Prescription;
import com.opdapp.model.PrescriptionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription,Long> {

    List<Prescription> findPrescriptionByPatient(final Patient patient);

    List<Prescription> findPrescriptionByDate(final Date date);

    List<Prescription> findPrescriptionByDateBetween(final Date fromDate,final Date toDate);

    List<Prescription> findPrescriptionByDateBetweenAndPrescriptionStatusIn
            (final Date fromDate, final Date toDate, final Set<PrescriptionStatus> statusSet);
}
