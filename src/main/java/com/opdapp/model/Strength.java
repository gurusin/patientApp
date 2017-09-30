package com.opdapp.model;

import javax.persistence.*;

@Entity
public class Strength {

    @Id
    @GeneratedValue
    private int strengthId;

    @ManyToOne
    @JoinColumn(name = "unitId")
    private StrengthUnit strengthUnit;

    private double strengthAmount;

    public StrengthUnit getStrengthUnit() {
        return strengthUnit;
    }

    public void setStrengthUnit(StrengthUnit strengthUnit) {
        this.strengthUnit = strengthUnit;
    }

    public int getStrengthId() {
        return strengthId;
    }

    public void setStrengthId(int strengthId) {
        this.strengthId = strengthId;
    }

    public double getStrengthAmount() {
        return strengthAmount;
    }

    public void setStrengthAmount(double strengthAmount) {
        this.strengthAmount = strengthAmount;
    }
}
