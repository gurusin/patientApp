package com.opdapp.repository;

import com.opdapp.model.PaymentDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailRepository extends CrudRepository<PaymentDetails, Long> {
}
