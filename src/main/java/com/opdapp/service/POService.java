package com.opdapp.service;

import com.opdapp.dto.*;
import com.opdapp.model.POStatus;
import com.opdapp.model.PurchaseOrder;

import java.util.List;

public interface POService {
    PurchaseOrder savePO(final PurchaseOrderDTO purchaseOrderDTO);

    POForGrnDTO loadForGrn(long podId);

    Object registerGRN(POForGrnDTO grn);

    void saveIssue(IssueDTO issueDTO);

    List<PurchaseOrderDTO> findPurchaseOrderByPoStatus(final POStatus poStatus);

    List<GRNDTOForPay> loadGRNForPay(String supplierInvoice);

    List<GRNDTOForPay> makePayment(final GRNDTOForPay gRNDTOForPay);

    GRNDTOForReturn loadGRNDTOForReturn(final String supplierInvoice);

    void saveGoodReturn(final GRNDTOForReturn gRNDTOForReturn);
}
