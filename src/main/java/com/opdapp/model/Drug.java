package com.opdapp.model;

import javax.persistence.*;

@Entity
public class Drug {

    @Id
    @GeneratedValue
    private long drugId;

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

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public BaseDrug getBaseDrug() {
        return baseDrug;
    }

    public void setBaseDrug(BaseDrug baseDrug) {
        this.baseDrug = baseDrug;
    }
}
