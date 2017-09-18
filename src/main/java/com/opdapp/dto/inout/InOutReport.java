package com.opdapp.dto.inout;

import com.opdapp.model.DrugPackage;

import java.util.List;

public class InOutReport
{
    private DrugPackage drugPackage;
    private List<InOutDetails> inOutDetailsList;

    public DrugPackage getDrugPackage() {
        return drugPackage;
    }

    public void setDrugPackage(DrugPackage drugPackage) {
        this.drugPackage = drugPackage;
    }

    public List<InOutDetails> getInOutDetailsList() {
        return inOutDetailsList;
    }

    public void setInOutDetailsList(List<InOutDetails> inOutDetailsList) {
        this.inOutDetailsList = inOutDetailsList;
    }
}
