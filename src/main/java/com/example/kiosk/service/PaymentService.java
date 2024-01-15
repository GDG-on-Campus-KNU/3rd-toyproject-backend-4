package com.example.kiosk.service;

import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.dto.PaymentRequest;
import jakarta.servlet.http.HttpSession;

public interface PaymentService {
    public Payment makePay(PaymentRequest paymentRequest, HttpSession session);
}
