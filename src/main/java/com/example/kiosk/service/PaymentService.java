package com.example.kiosk.service;

import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.dto.PaymentRequest;

public interface PaymentService {
    public Payment makePay(PaymentRequest paymentRequest);
}
