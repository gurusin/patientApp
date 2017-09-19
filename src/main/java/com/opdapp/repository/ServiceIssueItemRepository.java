package com.opdapp.repository;

import com.opdapp.model.BaseDrug;
import com.opdapp.model.ServiceIssueItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ServiceIssueItemRepository extends CrudRepository<ServiceIssueItem, Long> {

    List<ServiceIssueItem> findServiceIssueItemByDateBetween(final Date fromDate, final Date toDate);

    List<ServiceIssueItem> findByDate(final Date date);

}
