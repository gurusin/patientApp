package com.opdapp.dto.inout;

import java.util.Date;

public class InOutDetails
{
    private double received;
    private double issued;
    private Date date;
    private String supplierName;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getReceived() {
        return received;
    }

    public void setReceived(double received) {
        this.received = received;
    }

    public double getIssued() {
        return issued;
    }

    public void setIssued(double issued) {
        this.issued = issued;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
