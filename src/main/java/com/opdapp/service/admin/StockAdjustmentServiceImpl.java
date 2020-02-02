package com.opdapp.service.admin;

import com.opdapp.dto.common.DatePeriod;
import com.opdapp.model.DrugPackage;
import com.opdapp.model.admin.StockAdjustmentItem;
import com.opdapp.repository.DrugPackageRepository;
import com.opdapp.repository.StockAdjustmentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockAdjustmentServiceImpl implements StockAdjustmentService
{
    @Autowired
    private StockAdjustmentItemRepository stockAdjustmentItemRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    @Override
    public Object adjustStock(final StockAdjustmentItem item)
    {
        final DrugPackage drugPackage = drugPackageRepository.findById(item.getDrugPackage().getDrugPackageId()).get();
        drugPackage.setQuantity(drugPackage.getQuantity() + item.getAdjustedQty());
        stockAdjustmentItemRepository.save(item);
        drugPackageRepository.save(drugPackage);
        return new Object();
    }

    @Override
    public List<StockAdjustmentItem> findAdjustments(DatePeriod period) {
        return stockAdjustmentItemRepository.findByDateOfAdjustmentBetween(convert(period.getFromDate()),
                convert(period.getToDate()));
    }

    private java.sql.Date convert(java.util.Date date)
    {
        return new java.sql.Date(date.getTime());
    }
}
