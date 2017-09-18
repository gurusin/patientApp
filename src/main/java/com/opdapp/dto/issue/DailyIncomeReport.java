package com.opdapp.dto.issue;

import com.opdapp.dto.DailyIncome;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DailyIncomeReport {

    private Date date;
    private Collection<DailyIncome> drugIncome;
    private Collection<DailyIncome> servicesIncome;
    private double drugTotal;
    private double servicesTotal;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
