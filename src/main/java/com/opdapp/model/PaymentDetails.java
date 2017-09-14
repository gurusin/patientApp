package com.opdapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue
    private long paymentDetailsId;
    private Date paymentDate;
    private PaymentMode paymentMode;
    private long grnNo; //NOTE :This is not linked at entity level?
    private double amount;
    private PaymentMethod paymentMethod;
    private String paymentMethodDetails;

    public long getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(long paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public long getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(long grnNo) {
        this.grnNo = grnNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodDetails() {
        return paymentMethodDetails;
    }

    public void setPaymentMethodDetails(String paymentMethodDetails) {
        this.paymentMethodDetails = paymentMethodDetails;
    }
}
