package com.opdapp.model;

import java.io.Serializable;
import java.util.List;

public class PrescribableDrug implements Serializable {
    private Drug drug;
    private List<Strength> strengths;
    private List<DoseFrequency> doseFrequency;
    private double doseAmount;
    private double doseDuration;
    private List<String> durationUnit;
    List<DrugPackage> packages;

    public List<DrugPackage> getPackages() {
        return packages;
    }

    public void setPackages(List<DrugPackage> packages) {
        this.packages = packages;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public List<Strength> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<Strength> strengths) {
        this.strengths = strengths;
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

    public List<DoseFrequency> getDoseFrequency() {
        return doseFrequency;
    }

    public void setDoseFrequency(List<DoseFrequency> doseFrequency) {
        this.doseFrequency = doseFrequency;
    }
}
