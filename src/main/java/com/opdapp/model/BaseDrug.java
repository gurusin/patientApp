package com.opdapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaseDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int baseDrugId;
    private String baseDrugName;

    public int getBaseDrugId() {
        return baseDrugId;
    }

    public void setBaseDrugId(int baseDrugId) {
        this.baseDrugId = baseDrugId;
    }

    public String getBaseDrugName() {
        return baseDrugName;
    }

    public void setBaseDrugName(String baseDrugName) {
        this.baseDrugName = baseDrugName;
    }
}
