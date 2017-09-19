package com.opdapp.dto.issue;

import com.opdapp.model.Patient;
import com.opdapp.model.PrescriptionServiceItem;

import java.util.Date;
import java.util.Set;

public class MakeIssue {

    private long prescriptionId;

    private Patient patient;

    private Date dateOfIssue;

    private Set<PrescriptionServiceItem> serviceItems;

    private Set<MakeIssueDetailDTO> details;

    public Set<PrescriptionServiceItem> getServiceItems() {
        return serviceItems;
    }

    public void setServiceItems(Set<PrescriptionServiceItem> serviceItems) {
        this.serviceItems = serviceItems;
    }


    public Date getDateOfIssue() {
        return dateOfIssue;
    }


    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
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


    public Set<MakeIssueDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(Set<MakeIssueDetailDTO> details) {
        this.details = details;
    }
}
