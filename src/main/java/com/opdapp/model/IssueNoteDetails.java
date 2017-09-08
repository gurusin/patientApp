package com.opdapp.model;

import javax.persistence.*;

@Entity
public class IssueNoteDetails {

    @Id
    @GeneratedValue
    private long issueNoteId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", nullable = false)
    private IssueNote issueNote;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    private double buyingQuantity;

    public long getIssueNoteId() {
        return issueNoteId;
    }

    public void setIssueNoteId(long issueNoteId) {
        this.issueNoteId = issueNoteId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
