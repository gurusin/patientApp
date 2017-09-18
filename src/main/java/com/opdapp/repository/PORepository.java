package com.opdapp.repository;

import com.opdapp.model.POStatus;
import com.opdapp.model.PurchaseOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PORepository extends CrudRepository<PurchaseOrder,Long> {

    List<PurchaseOrder> findPurchaseOrderByPoStatus(final POStatus poStatus);

    @Query("select distinct p from PurchaseOrder p  join fetch " +
            "p.purchaseOrderDetails pd where pd.orderQty > pd.receivedQty")
    List<PurchaseOrder> findPending();
}
