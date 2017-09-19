package com.opdapp.model;

import javax.persistence.*;

@Entity
public class DrugPackage {

    @Id
    @GeneratedValue
    private long drugPackageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrugPackage)) return false;

        DrugPackage that = (DrugPackage) o;

        return getDrugPackageId() == that.getDrugPackageId();
    }

    @Override
    public int hashCode() {
        return (int)getDrugPackageId();
    }

    @ManyToOne
    @JoinColumn(name = "drugId")

    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "strengthId")
    private Strength strength;
    private double quantity;
    private double minOrderLevel;
    private double unitPrice;

    public long getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(long drugPackageId) {
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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
