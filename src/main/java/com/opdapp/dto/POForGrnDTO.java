package com.opdapp.dto;

import java.util.Date;
import java.util.List;

public class POForGrnDTO {
    private long poNumber;
    private String supplier;
    private List<PoForGrnDetailDTO> details;
    private Date expectedRecieveDate;

    public long getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(long poNumber) {
        this.poNumber = poNumber;
    }

    public List<PoForGrnDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<PoForGrnDetailDTO> details) {
        this.details = details;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getExpectedRecieveDate() {
        return expectedRecieveDate;
    }

    public void setExpectedRecieveDate(Date expectedRecieveDate) {
        this.expectedRecieveDate = expectedRecieveDate;
    }
}
