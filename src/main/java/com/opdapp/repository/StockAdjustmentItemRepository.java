package com.opdapp.repository;

import com.opdapp.model.admin.StockAdjustmentItem;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface StockAdjustmentItemRepository extends CrudRepository<StockAdjustmentItem,Long>
{
    List<StockAdjustmentItem> findByDateOfAdjustmentBetween(Date fromDate, Date toDate);
}
