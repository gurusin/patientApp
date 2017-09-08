package com.opdapp.dto;

public class PoForGrnDetailDTO
{
    private long poItemId;
    private long itemId;
    private String itemName;
    private double orderedQty;
    private double balanceQty;
    private double receivedQty;
    private long poDetailId;

    public long getPoItemId() {
        return poItemId;
    }

    public void setPoItemId(long poItemId) {
        this.poItemId = poItemId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(double orderedQty) {
        this.orderedQty = orderedQty;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public double getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(double receivedQty) {
        this.receivedQty = receivedQty;
    }

    public double getPoDetailId() {
        return poDetailId;
    }

    public void setPoDetailId(long poDetailId) {
        this.poDetailId = poDetailId;
    }
}
