package com.opdapp.model;

import javax.persistence.*;

@Entity
public class Drug {

    @Id
    @GeneratedValue
    private int drugId;

    @ManyToOne
    @JoinColumn(name = "baseDrugId")
    private BaseDrug baseDrug;

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public BaseDrug getBaseDrug() {
        return baseDrug;
    }

    public void setBaseDrug(BaseDrug baseDrug) {
        this.baseDrug = baseDrug;
    }
}
