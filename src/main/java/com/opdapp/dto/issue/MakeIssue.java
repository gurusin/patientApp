package com.opdapp.dto.issue;

import java.util.Set;

public class MakeIssue {

    private long issueNote;
    private Set<MakeIssueDetailDTO> details;

    public long getIssueNote() {
        return issueNote;
    }

    public void setIssueNote(long issueNote) {
        this.issueNote = issueNote;
    }

    public Set<MakeIssueDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(Set<MakeIssueDetailDTO> details) {
        this.details = details;
    }
}
