package com.opdapp.model;

import javax.persistence.*;

@Entity
public class DrugPackage {

    @Id
    @GeneratedValue
    private int drugPackageId;

    @ManyToOne
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "strengthId")
    private Strength strength;
    private int quantity;
    private double minOrderLevel;
    private double unitPrice;

    public int getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(int drugPackageId) {
        this.drugPackageId = drugPackageId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMinOrderLevel() {
        return minOrderLevel;
    }

    public void setMinOrderLevel(double minOrderLevel) {
        this.minOrderLevel = minOrderLevel;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
