package com.opdapp.model;

import javax.persistence.*;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Entity
public class PrescriptionDetail {

    @Id
    @GeneratedValue
    private long Id;

    private String strength;

    @ManyToOne()
    @JoinColumn(name = "doseFrequencyId")
    private DoseFrequency frequency;

    private double amount;

    private double duration;

    private String intervalUnit;

    @ManyToOne()
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescriptionId", nullable = false)
    private Prescription prescription;

    private Meal meal;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
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

    public String getIntervalUnit() {
        return intervalUnit;
    }

    public void setIntervalUnit(String intervalUnit) {
        this.intervalUnit = intervalUnit;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public DoseFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(DoseFrequency frequency) {
        this.frequency = frequency;
    }
}
