package com.opdapp.model;

import javax.persistence.*;

@Entity
public class DrugPackageBatch {

    @Id
    @GeneratedValue
    private int batchId;


    @ManyToOne
    @JoinColumn(name = "supplierId")
    private ItemSupplier supplier;

    @ManyToOne
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;
    private double quantity;

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public ItemSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(ItemSupplier supplier) {
        this.supplier = supplier;
    }

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
