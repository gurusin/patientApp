package com.opdapp.model;

import javax.persistence.*;

@Entity
public class StrengthUnit {

    @Id
    @GeneratedValue
    private long unitId;
    private String unitName;

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
