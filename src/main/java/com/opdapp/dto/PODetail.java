package com.opdapp.dto;

public class PODetail
{
    private long itemId;
    private double qty;
    private long podetailId;
    private String itemName;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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
