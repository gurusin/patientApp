package com.opdapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Returnsout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long returnOutId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "returnsout", cascade = CascadeType.ALL)
    private Set<ReturnOutDetail> returnOutDetail;

    private Date returnDate;

    private String supplierInvoice;

    public long getReturnOutId() {
        return returnOutId;
    }

    public void setReturnOutId(long returnOutId) {
        this.returnOutId = returnOutId;
    }

    public Set<ReturnOutDetail> getReturnOutDetail() {
        return returnOutDetail;
    }

    public void setReturnOutDetail(Set<ReturnOutDetail> returnOutDetail) {
        this.returnOutDetail = returnOutDetail;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(String supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }
}
