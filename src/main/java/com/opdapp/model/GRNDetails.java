package com.opdapp.model;


import javax.persistence.*;

@Entity
public class GRNDetails {
    @Id
    @GeneratedValue
    private long grnDetailNo;

    private double receivingQty;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "drnid", nullable = false)
    private GoodReceivingNote goodReceivingNote;

    public long getGrnDetailNo() {
        return grnDetailNo;
    }

    public void setGrnDetailNo(long grnDetailNo) {
        this.grnDetailNo = grnDetailNo;
    }

    public double getReceivingQty() {
        return receivingQty;
    }

    public void setReceivingQty(double receivingQty) {
        this.receivingQty = receivingQty;
    }

    public GoodReceivingNote getGoodReceivingNote() {
        return goodReceivingNote;
    }

    public void setGoodReceivingNote(GoodReceivingNote goodReceivingNote) {
        this.goodReceivingNote = goodReceivingNote;
    }
}
