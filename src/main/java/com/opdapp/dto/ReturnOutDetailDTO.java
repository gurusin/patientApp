package com.opdapp.dto;

public class ReturnOutDetailDTO {
    private long retOutDetailNo;

    private double returnQty;

    private String drugName;

    private int drugPackageId;

    private double recievedQty;

    private long grnDetailNo;

    public long getRetOutDetailNo() {
        return retOutDetailNo;
    }

    public void setRetOutDetailNo(long retOutDetailNo) {
        this.retOutDetailNo = retOutDetailNo;
    }

    public double getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(double returnQty) {
        this.returnQty = returnQty;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getDrugPackageId() {
        return drugPackageId;
    }

    public void setDrugPackageId(int drugPackageId) {
        this.drugPackageId = drugPackageId;
    }

    public double getRecievedQty() {
        return recievedQty;
    }

    public void setRecievedQty(double recievedQty) {
        this.recievedQty = recievedQty;
    }

    public long getGrnDetailNo() {
        return grnDetailNo;
    }

    public void setGrnDetailNo(long grnDetailNo) {
        this.grnDetailNo = grnDetailNo;
    }
}
