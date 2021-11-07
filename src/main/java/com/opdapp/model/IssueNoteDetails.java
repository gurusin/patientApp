package com.opdapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class IssueNoteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueNoteId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", nullable = false)
    @JsonBackReference
    private IssueNote issueNote;

    @ManyToOne
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;

    private double buyingQuantity;

    private double prescribedQty;

    private double balanceQty;

    private String issueInformation;

    public String getIssueInformation() {
        return issueInformation;
    }

    public void setIssueInformation(String issueInformation) {
        this.issueInformation = issueInformation;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public double getPrescribedQty() {
        return prescribedQty;
    }

    public void setPrescribedQty(double prescribedQty) {
        this.prescribedQty = prescribedQty;
    }

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

    @PostLoad
    public void prepare()
    {
        if (issueInformation == null)
        {
            issueInformation ="";
        }
    }
}
