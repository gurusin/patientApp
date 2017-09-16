package com.opdapp.repository;

import com.opdapp.model.Returnsout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrunsoutRepository extends CrudRepository<Returnsout, Long> {
}
