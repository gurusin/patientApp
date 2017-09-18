package com.opdapp.dto;

public class DrugDTO {

    private long drugId;

    private BaseDrugDTO baseDrug;

    private String brandName;

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
