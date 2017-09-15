package com.opdapp.service.impl;

import com.opdapp.model.PaymentMethod;
import com.opdapp.service.PaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Override
    public List<PaymentMethod> loadPaymentMethod() {
        List<PaymentMethod> paymentMethodList = new ArrayList<PaymentMethod>();
        paymentMethodList.add(PaymentMethod.CASH);
        paymentMethodList.add(PaymentMethod.CHEQUE);
        paymentMethodList.add(PaymentMethod.CREDIT);
        paymentMethodList.add(PaymentMethod.VOUCHER);
        return paymentMethodList;
    }

}
