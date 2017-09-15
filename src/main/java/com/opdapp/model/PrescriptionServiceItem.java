package com.opdapp.model;

import javax.persistence.*;

@Entity
public class PrescriptionServiceItem{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "medServiceItemId")
    private MedicalServItem medicalServItem;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescriptionId", nullable = false)
    private Prescription prescription;

    private double fee;

    private String externalRef;

    public String getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MedicalServItem getMedicalServItem() {
        return medicalServItem;
    }

    public void setMedicalServItem(MedicalServItem medicalServItem) {
        this.medicalServItem = medicalServItem;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
