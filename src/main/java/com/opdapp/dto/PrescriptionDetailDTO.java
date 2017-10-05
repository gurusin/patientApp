package com.opdapp.dto;

import com.opdapp.model.DoseFrequency;
import com.opdapp.model.Drug;
import com.opdapp.model.Meal;

/**
 * Created by sudarshana on 13/08/2017.
 */
public class PrescriptionDetailDTO {

    private long drugPackageId;
    private double amount;
    private double duration;
    private long doseFrequencyId;
    private Meal meal;
    private String intervalUnit;
    private double neededQty;

    public double getNeededQty() {
        return neededQty;
    }

    public void setNeededQty(double neededQty) {
        this.neededQty = neededQty;
    }

    public long getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(long drugPackageId) {
        this.drugPackageId = drugPackageId;
    }

    public long getDoseFrequencyId() {
        return doseFrequencyId;
    }

    public void setDoseFrequencyId(long doseFrequencyId) {
        this.doseFrequencyId = doseFrequencyId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getIntervalUnit() {
        return intervalUnit;
    }

    public void setIntervalUnit(String intervalUnit) {
        this.intervalUnit = intervalUnit;
    }

}
