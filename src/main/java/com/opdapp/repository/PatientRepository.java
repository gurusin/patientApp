package com.opdapp.repository;

import com.opdapp.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sudarshana on 07/08/2017.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient,Long>
{
    List<Patient> findByNicLike(final String nic);
}
