package com.opdapp.dto.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opdapp.dto.DailyIncome;

import java.util.Collection;
import java.util.Date;

public class DailyIncomeReport {

    private Date fromDate;
    private Collection<DailyIncome> drugIncome;
    private Collection<DailyIncome> servicesIncome;

    private double drugTotal;
    private double servicesTotal;
    private Date toDate;

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Collection<DailyIncome> getDrugIncome() {
        return drugIncome;
    }

    public void setDrugIncome(Collection<DailyIncome> drugIncome) {
        this.drugIncome = drugIncome;
    }

    public Collection<DailyIncome> getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Collection<DailyIncome> servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getDrugTotal() {
        return drugTotal;
    }

    public void setDrugTotal(double drugTotal) {
        this.drugTotal = drugTotal;
    }

    public double getServicesTotal() {
        return servicesTotal;
    }

    public void setServicesTotal(double servicesTotal) {
        this.servicesTotal = servicesTotal;
    }
}
