package com.opdapp.service;

import com.opdapp.dto.GRNDTOForPay;
import com.opdapp.dto.IssueDTO;
import com.opdapp.dto.POForGrnDTO;
import com.opdapp.dto.PurchaseOrderDTO;
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
}
