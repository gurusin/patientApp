package com.opdapp.repository;

import com.opdapp.model.IssueNote;
import com.opdapp.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IssueNoteRepository extends CrudRepository<IssueNote, Long> {
    List<IssueNote> findIssueNoteByExternalIdIn(List<Long> externalIds);

    List<IssueNote> findByIssueDate(final Date date);

    List<IssueNote> findByIssueDateBetween(final Date fromDate, final Date toDate);

    Iterable<IssueNote> findByPatient(Patient patient);
}
