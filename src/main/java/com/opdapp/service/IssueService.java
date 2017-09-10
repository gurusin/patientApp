package com.opdapp.service;

import com.opdapp.dto.issue.MakeIssue;
import com.opdapp.model.IssueNote;

public interface IssueService {

    IssueNote findIssue(final long issueNo);

    void makeIssue(MakeIssue issue);
}
