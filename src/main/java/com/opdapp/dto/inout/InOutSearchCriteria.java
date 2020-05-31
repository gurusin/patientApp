package com.opdapp.dto.inout;


import lombok.Data;
import org.joda.time.LocalDate;

import java.util.Date;

@Data
public class InOutSearchCriteria
{
    private Date fromDate;
    private Date toDate;
    private long drugId;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
