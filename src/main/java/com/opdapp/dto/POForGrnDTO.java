package com.opdapp.dto;

import java.util.List;

public class POForGrnDTO
{
    private long poNumber;
    private List<PoForGrnDetailDTO> details;

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
}
