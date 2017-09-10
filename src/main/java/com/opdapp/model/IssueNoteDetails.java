package com.opdapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class IssueNoteDetails {

    @Id
    @GeneratedValue
    private long issueNoteId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", nullable = false)
    @JsonBackReference
    private IssueNote issueNote;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private DrugPackage drugPackage;

    private double buyingQuantity;

    public long getIssueNoteId() {
        return issueNoteId;
    }

    public void setIssueNoteId(long issueNoteId) {
        this.issueNoteId = issueNoteId;
    }

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public double getBuyingQuantity() {
        return buyingQuantity;
    }

    public void setBuyingQuantity(double buyingQuantity) {
        this.buyingQuantity = buyingQuantity;
    }

    public IssueNote getIssueNote() {
        return issueNote;
    }

    public void setIssueNote(IssueNote issueNote) {
        this.issueNote = issueNote;
    }
}
