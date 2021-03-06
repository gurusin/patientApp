package com.opdapp.dto;

import com.opdapp.model.DrugPackage;
import com.opdapp.model.MedicalServItem;
import com.opdapp.model.Patient;
import com.opdapp.model.PrescriptionDetail;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by sudarshana on 13/08/2017.
 */
public class PrescriptionDTO {
    private long prescriptionId;
    private long patientId;
    private String patientName;
    private String diagnosis;
    private String notes;
    private String symptoms;
    private Date prescriptionDate;
    private Set<MedicalServItem> medicalServices;
    private Patient patient;
    private String externalNote;
    private List<PrescriptionDetailDTO> prescriptionDetailDTOS;

    public String getExternalNote() {
        return externalNote;
    }

    public void setExternalNote(String externalNote) {
        this.externalNote = externalNote;
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



    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public List<PrescriptionDetailDTO> getPrescriptionDetailDTOS() {
        return prescriptionDetailDTOS;
    }

    public void setPrescriptionDetailDTOS(List<PrescriptionDetailDTO> prescriptionDetailDTOS) {
        this.prescriptionDetailDTOS = prescriptionDetailDTOS;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Set<MedicalServItem> getMedicalServices() {
        return medicalServices;
    }

    public void setMedicalServices(Set<MedicalServItem> medicalServices) {
        this.medicalServices = medicalServices;
    }
}
