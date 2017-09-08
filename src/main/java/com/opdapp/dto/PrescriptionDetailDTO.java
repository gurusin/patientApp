package com.opdapp.dto;

import com.opdapp.model.DoseFrequency;
import com.opdapp.model.Drug;
import com.opdapp.model.Meal;

/**
 * Created by sudarshana on 13/08/2017.
 */
public class PrescriptionDetailDTO {
    private Drug drug;
    private double amount;
    private double duration;
    private String strength;
    private DoseFrequency frequency;
    private Meal meal;
    private String intervalUnit;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
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

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
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

    public DoseFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(DoseFrequency frequency) {
        this.frequency = frequency;
    }
}
