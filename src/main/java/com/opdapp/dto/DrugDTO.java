package com.opdapp.dto;

public class DrugDTO {

    private long drugId;

    private BaseDrugDTO baseDrug;

    private String brandName;

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public BaseDrugDTO getBaseDrug() {
        return baseDrug;
    }

    public void setBaseDrug(BaseDrugDTO baseDrug) {
        this.baseDrug = baseDrug;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
