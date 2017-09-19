package com.opdapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Entity
public class PrescriptionDetail {

    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne()
    @JoinColumn(name = "doseFrequencyId")
    private DoseFrequency frequency;

    private double amount;

    private double duration;

    private String intervalUnit;

    @ManyToOne()
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescriptionId", nullable = false)
    @JsonBackReference
    private Prescription prescription;

    private Meal meal;

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

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
