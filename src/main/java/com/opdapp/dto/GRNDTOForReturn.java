package com.opdapp.dto;

import java.sql.Date;
import java.util.List;

public class GRNDTOForReturn {
    private long returnOutId;

    private Date returnDate;

    private long drnid;

    private Date grnDate;

    private String supplierInvoice;

    private String supplierName;

    private List<ReturnOutDetailDTO> returnOutDetailDTOList;

    public long getReturnOutId() {
        return returnOutId;
    }

    public void setReturnOutId(long returnOutId) {
        this.returnOutId = returnOutId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public long getDrnid() {
        return drnid;
    }

    public void setDrnid(long drnid) {
        this.drnid = drnid;
    }

    public Date getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(Date grnDate) {
        this.grnDate = grnDate;
    }

    public String getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(String supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public List<ReturnOutDetailDTO> getReturnOutDetailDTOList() {
        return returnOutDetailDTOList;
    }

    public void setReturnOutDetailDTOList(List<ReturnOutDetailDTO> returnOutDetailDTOList) {
        this.returnOutDetailDTOList = returnOutDetailDTOList;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
