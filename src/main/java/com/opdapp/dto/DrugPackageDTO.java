package com.opdapp.dto;

public class DrugPackageDTO {

    private int drugPackageId;

    private DrugDTO drug;

    private StrengthDTO strength;

    private int quantity;

    private double minOrderLevel;

    private double unitPrice;

    public int getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(int drugPackageId) {
        this.drugPackageId = drugPackageId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DrugDTO getDrug() {
        return drug;
    }

    public void setDrug(DrugDTO drug) {
        this.drug = drug;
    }

    public StrengthDTO getStrength() {
        return strength;
    }

    public void setStrength(StrengthDTO strength) {
        this.strength = strength;
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
