package com.opdapp.repository;

import com.opdapp.model.IssueNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueNoteRepository extends CrudRepository<IssueNote, Long> {
}
