package com.opdapp.repository;

import com.opdapp.model.BaseDrug;
import com.opdapp.model.PrescriptionIssueDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PrescriptionIssueDetailRepository
        extends CrudRepository<PrescriptionIssueDetail, Integer> {

    List<PrescriptionIssueDetail> findByPrescriptionDetailIdIn(Collection<Long> ids);

}
