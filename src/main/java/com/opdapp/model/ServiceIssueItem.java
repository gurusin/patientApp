package com.opdapp.model;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
/**
 * Represents a service obtained
 */
public class ServiceIssueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    private Patient patient;

    private long prescriptionId;

    @ManyToOne()
    private MedicalServItem medicalServItem;

    private double fee;

    private String exteranlId;

    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    public String getExteranlId() {
        return exteranlId;
    }

    public void setExteranlId(String exteranlId) {
        this.exteranlId = exteranlId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
