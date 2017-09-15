package com.opdapp.service;

import com.opdapp.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> loadPaymentMethod();
}
