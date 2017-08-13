package com.opdapp.model;

import java.io.Serializable;
import java.util.List;

public class PrescribableDrug implements Serializable{
    private Drug drug;
    private List<String> strengths;
    private List<String> doseFrequency;
    private double doseAmount;
    private double doseDuration;
    private List<String> durationUnit;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getDoseFrequency() {
        return doseFrequency;
    }

    public void setDoseFrequency(List<String> doseFrequency) {
        this.doseFrequency = doseFrequency;
    }

    public double getDoseAmount() {
        return doseAmount;
    }

    public void setDoseAmount(double doseAmount) {
        this.doseAmount = doseAmount;
    }

    public double getDoseDuration() {
        return doseDuration;
    }

    public void setDoseDuration(double doseDuration) {
        this.doseDuration = doseDuration;
    }

    public List<String> getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(List<String> durationUnit) {
        this.durationUnit = durationUnit;
    }
}
