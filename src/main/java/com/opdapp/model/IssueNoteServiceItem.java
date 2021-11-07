package com.opdapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class IssueNoteServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "medServiceItemId")
    private MedicalServItem medicalServItem;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", nullable = false)
    @JsonBackReference
    private IssueNote issueNote;

    private double fee;

    private String externalId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IssueNote getIssueNote() {
        return issueNote;
    }

    public void setIssueNote(IssueNote issueNote) {
        this.issueNote = issueNote;
    }

    public MedicalServItem getMedicalServItem() {
        return medicalServItem;
    }

    public void setMedicalServItem(MedicalServItem medicalServItem) {
        this.medicalServItem = medicalServItem;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
