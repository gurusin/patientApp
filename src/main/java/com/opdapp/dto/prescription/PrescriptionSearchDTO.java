package com.opdapp.dto.prescription;

import java.sql.Date;

/**
 * Used to send the search parameters for searching prescriptions
 *
 */
public class PrescriptionSearchDTO {

    private Date fromDate;
    private Date toDate;
    private boolean initial;
    private boolean all;
    private boolean partCompleted;
    private boolean completed;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public boolean isPartCompleted() {
        return partCompleted;
    }

    public void setPartCompleted(boolean partCompleted) {
        this.partCompleted = partCompleted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
