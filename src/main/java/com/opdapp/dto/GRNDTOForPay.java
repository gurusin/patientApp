package com.opdapp.dto;

import com.opdapp.model.GRNDetails;
import com.opdapp.model.GRNStatus;
import com.opdapp.model.PaymentDetails;
import com.opdapp.model.PurchaseOrder;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

public class GRNDTOForPay {
    private long drnid;

    private Set<PoForGrnDetailDTO> poForGrnDetailDTO;

    private Date grnDate;

    private GRNStatus grnStatus;

    private String supplierInvoice;

    private PaymentDetails paymentDetails;

    public long getDrnid() {
        return drnid;
    }

    public void setDrnid(long drnid) {
        this.drnid = drnid;
    }

    public Date getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(Date grnDate) {
        this.grnDate = grnDate;
    }

    public GRNStatus getGrnStatus() {
        return grnStatus;
    }

    public void setGrnStatus(GRNStatus grnStatus) {
        this.grnStatus = grnStatus;
    }

    public String getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(String supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Set<com.opdapp.dto.PoForGrnDetailDTO> getPoForGrnDetailDTO() {
        return poForGrnDetailDTO;
    }

    public void setPoForGrnDetailDTO(Set<com.opdapp.dto.PoForGrnDetailDTO> poForGrnDetailDTO) {
        this.poForGrnDetailDTO = poForGrnDetailDTO;
    }
}
