package com.opdapp.dto;

import com.opdapp.model.PaymentMethod;
import com.opdapp.model.PaymentMode;

import java.sql.Date;

public class PaymentDTO {
    private long paymentDetailsId;
    private Date paymentDate;
    private PaymentMode paymentMode;
    private long grnNo; //NOTE :This is not linked at entity level?
    private double amount;
    private PaymentMethod paymentMethod;
    private String paymentMethodDetails; //check no or voucher no etc...
}
