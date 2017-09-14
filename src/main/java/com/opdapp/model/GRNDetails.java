package com.opdapp.model;


import javax.persistence.*;

@Entity
public class GRNDetails {
    @Id
    @GeneratedValue
    private long grnDetailNo;

    private double receivingQty;


    @ManyToOne()
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;

    private double itemBoughtPrice;

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

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public double getItemBoughtPrice() {
        return itemBoughtPrice;
    }

    public void setItemBoughtPrice(double itemBoughtPrice) {
        this.itemBoughtPrice = itemBoughtPrice;
    }
}
