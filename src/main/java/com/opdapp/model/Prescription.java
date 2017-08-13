package com.opdapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by sudarshana on 13/08/2017.
 */

@Entity
@Table
public class Prescription {

    @Id
    @GeneratedValue
    private long id;

    private String symptoms;

    private String diagnosis;

    private String notes;

    @ManyToOne()
    @JoinColumn(name = "patientId")
    private Patient patient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prescription",cascade = CascadeType.ALL)
    private Set<PrescriptionDetail> prescriptionDetails;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<PrescriptionDetail> getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(Set<PrescriptionDetail> prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }
}
