package com.opdapp.model;


import javax.persistence.*;

@Entity
public class ReturnOutDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long retOutDetailNo;

    private double returnQty;

    @ManyToOne()
    @JoinColumn(name = "drugPackageId")
    private DrugPackage drugPackage;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "returnOutId", nullable = false)
    private Returnsout returnsout;

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

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public Returnsout getReturnsout() {
        return returnsout;
    }

    public void setReturnsout(Returnsout returnsout) {
        this.returnsout = returnsout;
    }
}
