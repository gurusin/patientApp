package com.opdapp.model;

import javax.persistence.*;

@Entity
public class Dose {

    public int getDoseId() {
        return doseId;
    }

    public void setDoseId(int doseId) {
        this.doseId = doseId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public double getDoseSize() {
        return doseSize;
    }

    public void setDoseSize(double doseSize) {
        this.doseSize = doseSize;
    }

    public DoseFrequency getDoseFrequency() {
        return doseFrequency;
    }

    public void setDoseFrequency(DoseFrequency doseFrequency) {
        this.doseFrequency = doseFrequency;
    }

    public DurationUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(DurationUnit durationUnit) {
        this.durationUnit = durationUnit;
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

    public PatientVisit getPatientVisit() {
        return patientVisit;
    }

    public void setPatientVisit(PatientVisit patientVisit) {
        this.patientVisit = patientVisit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doseId;

    @ManyToOne
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "strengthId")
    private Strength strength;
    private double doseSize;

    @ManyToOne
    @JoinColumn(name = "doseFrequencyId")
    private DoseFrequency doseFrequency;

    @ManyToOne
    @JoinColumn(name = "unitId")
    private DurationUnit durationUnit;
    private double duration;
    private Meal meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitId", nullable = false, insertable = false, updatable = false)
    private PatientVisit patientVisit;

}
