package com.opdapp.dto;

import com.opdapp.model.POStatus;
import org.joda.time.LocalDate;

import java.util.List;

public class PurchaseOrderDTO {

    private long supplierId;
    private List<PODetail> poDetails;
    private LocalDate orderDate;
    private LocalDate expectedRecieveDate;
    private POStatus poStatus;
    private long purchaseOrderNo;
    private String supplierName;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public List<PODetail> getPoDetails() {
        return poDetails;
    }

    public void setPoDetails(List<PODetail> poDetails) {
        this.poDetails = poDetails;
    }

    public LocalDate getExpectedRecieveDate() {
        return expectedRecieveDate;
    }

    public void setExpectedRecieveDate(LocalDate expectedRecieveDate) {
        this.expectedRecieveDate = expectedRecieveDate;
    }

    public POStatus getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(POStatus poStatus) {
        this.poStatus = poStatus;
    }

    public long getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(long purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
