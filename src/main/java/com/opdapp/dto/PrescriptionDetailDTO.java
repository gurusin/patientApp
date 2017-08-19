package com.opdapp.dto;

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
    private String frequency;
    private Meal meal;

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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
