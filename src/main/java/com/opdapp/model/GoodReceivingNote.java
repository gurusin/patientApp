package com.opdapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
public class GoodReceivingNote {
    @Id
    @GeneratedValue
    private long drnid;

    @ManyToOne
    @JoinColumn(name = "purchaseOrderNo")
    @JsonBackReference
    private PurchaseOrder purchaseOrder;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goodReceivingNote", cascade = CascadeType.ALL)
    private Set<GRNDetails> gRNDetails;

    private Date grnDate;

    private GRNStatus grnStatus;

    private String supplierInvoice;

    public long getDrnid() {
        return drnid;
    }

    public void setDrnid(long drnid) {
        this.drnid = drnid;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Set<GRNDetails> getgRNDetails() {
        return gRNDetails;
    }

    public void setgRNDetails(Set<GRNDetails> gRNDetails) {
        this.gRNDetails = gRNDetails;
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
}
