package com.opdapp.model.admin;

import com.opdapp.model.DrugPackage;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
public class StockAdjustmentItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private Date dateOfAdjustment;

    @ManyToOne
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;

    private double adjustedQty;

    private  String remarks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOfAdjustment() {
        return dateOfAdjustment;
    }

    public void setDateOfAdjustment(Date dateOfAdjustment) {
        this.dateOfAdjustment = dateOfAdjustment;
    }

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public double getAdjustedQty() {
        return adjustedQty;
    }

    public void setAdjustedQty(double adjustedQty) {
        this.adjustedQty = adjustedQty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
