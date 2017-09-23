package com.opdapp.service.admin;

import com.opdapp.dto.common.DatePeriod;
import com.opdapp.model.admin.StockAdjustmentItem;

import java.util.List;

public interface StockAdjustmentService
{
    Object adjustStock(StockAdjustmentItem item);

    /**
     * Finds the  adjustments for the given period.
     * @param period
     * @return
     */
    List<StockAdjustmentItem> findAdjustments(DatePeriod period);
}
