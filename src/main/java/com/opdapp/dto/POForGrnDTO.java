package com.opdapp.dto;

import com.opdapp.model.GRNStatus;
import com.opdapp.model.PaymentDetails;

import java.util.Date;
import java.util.List;

public class POForGrnDTO {
    private long poNumber;
    private String supplier;
    private List<PoForGrnDetailDTO> details;
    private Date expectedRecieveDate;
    private GRNStatus grnStatus;
    private PaymentDetails paymentDetails;

    private String supplierInvoice;

    public long getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(long poNumber) {
        this.poNumber = poNumber;
    }

    public List<PoForGrnDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<PoForGrnDetailDTO> details) {
        this.details = details;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getExpectedRecieveDate() {
        return expectedRecieveDate;
    }

    public void setExpectedRecieveDate(Date expectedRecieveDate) {
        this.expectedRecieveDate = expectedRecieveDate;
    }

    public GRNStatus getGrnStatus() {
        return grnStatus;
    }

    public void setGrnStatus(GRNStatus grnStatus) {
        this.grnStatus = grnStatus;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(String supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }
}
