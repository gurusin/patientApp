package com.opdapp.dto.issue;

public class MakeIssueDetailDTO
{
    private long issueNoteId;
    private double issuedQty;

    public long getIssueNoteId() {
        return issueNoteId;
    }

    public void setIssueNoteId(long issueNoteId) {
        this.issueNoteId = issueNoteId;
    }

    public double getIssuedQty() {
        return issuedQty;
    }

    public void setIssuedQty(double issuedQty) {
        this.issuedQty = issuedQty;
    }
}
