package com.opdapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
public class PatientVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitId")
    private int visitId;
    @Column(name = "symptoms")
    private String symptoms;
    @Column(name = "siagnosys")
    private String diagnosys;
    @Column(name = "note")
    private String note;
    @Column(name = "visitDate")
    private Date date;
    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patientId" , nullable = false, updatable = false, insertable = false)
    private Patient patient;


    public Set<Dose> getDose() {
        return dose;
    }

    public void setDose(Set<Dose> dose) {
        this.dose = dose;
    }

    @ManyToOne(targetEntity = Dose.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "visitId", nullable = false , insertable = false, updatable = false)
    private Set<Dose> dose;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosys() {
        return diagnosys;
    }

    public void setDiagnosys(String diagnosys) {
        this.diagnosys = diagnosys;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}

