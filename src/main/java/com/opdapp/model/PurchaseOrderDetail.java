package com.opdapp.model;


import javax.persistence.*;

@Entity
public class PurchaseOrderDetail {
    @Id
    @GeneratedValue
    private long purchaseOrderDetailId;

    @ManyToOne
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;

    private double orderQty;

    @ManyToOne
    @JoinColumn(name = "purchaseOrderNo")
    private PurchaseOrder purchaseOrder;

    private double receivedQty;

    public long getPurchaseOrderDetailId() {
        return purchaseOrderDetailId;
    }

    public void setPurchaseOrderDetailId(long purchaseOrderDetailId) {
        this.purchaseOrderDetailId = purchaseOrderDetailId;
    }

    public double getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(double receivedQty) {
        this.receivedQty = receivedQty;
    }

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(double orderQty) {
        this.orderQty = orderQty;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
