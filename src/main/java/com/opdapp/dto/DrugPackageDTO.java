package com.opdapp.dto;

import com.opdapp.model.DrugPackageContentType;

public class DrugPackageDTO {

    private long drugPackageId;

    private DrugDTO drug;

    private StrengthDTO strength;

    private double quantity;

    private double minOrderLevel;

    private double unitPrice;

    DrugPackageContentType drugPackageContentType;

    public DrugPackageContentType getDrugPackageContentType() {
        return drugPackageContentType;
    }

    public void setDrugPackageContentType(DrugPackageContentType drugPackageContentType) {
        this.drugPackageContentType = drugPackageContentType;
    }

    public long getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(long drugPackageId) {
        this.drugPackageId = drugPackageId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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
