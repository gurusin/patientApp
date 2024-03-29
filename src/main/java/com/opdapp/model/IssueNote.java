package com.opdapp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class IssueNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueNote;

    private Date issueDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueNote", cascade = CascadeType.ALL)
    private Set<IssueNoteDetails> issueNoteDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueNote", cascade = CascadeType.ALL)
    private Set<IssueNoteServiceItem> issueNoteServiceItems;


    private long prescriptionId;


    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    private PaymentMethod paymentMethod;

    private IssueStatus issueStatus;

    /* May be the ID of the purchase order in this case */
    private long externalId;

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public long getIssueNote() {
        return issueNote;
    }

    public void setIssueNote(long issueNote) {
        this.issueNote = issueNote;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<IssueNoteDetails> getIssueNoteDetails() {
        return issueNoteDetails;
    }

    public void setIssueNoteDetails(Set<IssueNoteDetails> issueNoteDetails) {
        this.issueNoteDetails = issueNoteDetails;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public Set<IssueNoteServiceItem> getIssueNoteServiceItems() {
        return issueNoteServiceItems;
    }

    public void setIssueNoteServiceItems(Set<IssueNoteServiceItem> issueNoteServiceItems) {
        this.issueNoteServiceItems = issueNoteServiceItems;
    }
}
