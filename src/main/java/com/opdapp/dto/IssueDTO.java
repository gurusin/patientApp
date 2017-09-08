package com.opdapp.dto;

import com.opdapp.model.IssueStatus;
import com.opdapp.model.PaymentMethod;

import java.sql.Date;
import java.util.List;

public class IssueDTO {
    private Date issueDate;

    private IssueStatus issueStatus;

    private PaymentMethod paymentMethod;

    private List<IssueDetailDTO> details;

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public List<IssueDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<IssueDetailDTO> details) {
        this.details = details;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
