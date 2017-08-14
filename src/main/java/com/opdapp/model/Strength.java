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

    private int strengthAmount;

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

    public int getStrengthAmount() {
        return strengthAmount;
    }

    public void setStrengthAmount(int strengthAmount) {
        this.strengthAmount = strengthAmount;
    }
}
