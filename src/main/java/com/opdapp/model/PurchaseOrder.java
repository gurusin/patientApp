package com.opdapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue
    private long purchaseOrderNo;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private ItemSupplier itemSupplier;
    private Date orderedDate;
    private Date expectedRecieveDate;
    private POStatus poStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseOrder",cascade = CascadeType.ALL)
    private Set<GoodReceivingNote> goodReceivingNote;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseOrder",cascade = CascadeType.ALL)
    private Set<PurchaseOrderDetail> purchaseOrderDetails;

    public long getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(long purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public ItemSupplier getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(ItemSupplier itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getExpectedRecieveDate() {
        return expectedRecieveDate;
    }

    public void setExpectedRecieveDate(Date expectedRecieveDate) {
        this.expectedRecieveDate = expectedRecieveDate;
    }

    public Set<GoodReceivingNote> getGoodReceivingNote() {
        return goodReceivingNote;
    }

    public void setGoodReceivingNote(Set<GoodReceivingNote> goodReceivingNote) {
        this.goodReceivingNote = goodReceivingNote;
    }

    public Set<PurchaseOrderDetail> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(Set<PurchaseOrderDetail> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public POStatus getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(POStatus poStatus) {
        this.poStatus = poStatus;
    }
}
