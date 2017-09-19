package com.opdapp.dto;

public class PODetail {
    private long drugPackageId;
    private double qty;
    private long podetailId;
    private String itemName;

    public long getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(long drugPackageId) {
        this.drugPackageId = drugPackageId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public long getPodetailId() {
        return podetailId;
    }

    public void setPodetailId(long podetailId) {
        this.podetailId = podetailId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
