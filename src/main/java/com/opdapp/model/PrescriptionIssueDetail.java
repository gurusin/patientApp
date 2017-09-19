package com.opdapp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
/**
 * Keeps track of The issues for the Prescription
 */
public class PrescriptionIssueDetail {

    @Id
    @GeneratedValue
    private long id;

    private long prescriptionDetailId;

    private double prescribedAmount;

    private double balanceAmount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrescriptionDetailId() {
        return prescriptionDetailId;
    }

    public void setPrescriptionDetailId(long prescriptionDetailId) {
        this.prescriptionDetailId = prescriptionDetailId;
    }

    public double getPrescribedAmount() {
        return prescribedAmount;
    }

    public void setPrescribedAmount(double prescribedAmount) {
        this.prescribedAmount = prescribedAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
