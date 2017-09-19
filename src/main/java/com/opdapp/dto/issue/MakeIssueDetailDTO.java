package com.opdapp.dto.issue;

import com.opdapp.model.DrugPackage;
import com.opdapp.model.PrescriptionServiceItem;

import java.util.Set;

public class MakeIssueDetailDTO
{
    private double issuedQty;
    private DrugPackage drugPackage;
    private double prescribedQty;
    private long prescriptionDetailId;
    private String duration;
    private String frequency;
    private double dose;

    /*Always from the client - issued amount in this issue*/
    private double currentIssuedQty;

    public double getCurrentIssuedQty() {
        return currentIssuedQty;
    }

    public void setCurrentIssuedQty(double currentIssuedQty) {
        this.currentIssuedQty = currentIssuedQty;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getPrescriptionDetailId() {
        return prescriptionDetailId;
    }

    public void setPrescriptionDetailId(long prescriptionDetailId) {
        this.prescriptionDetailId = prescriptionDetailId;
    }

    public double getPrescribedQty() {
        return prescribedQty;
    }

    public void setPrescribedQty(double prescribedQty) {
        this.prescribedQty = prescribedQty;
    }

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }


    public double getIssuedQty() {
        return issuedQty;
    }

    public void setIssuedQty(double issuedQty) {
        this.issuedQty = issuedQty;
    }
}
