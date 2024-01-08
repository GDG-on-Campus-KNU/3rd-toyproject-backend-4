package com.example.kiosk.controller;

import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.dto.PaymentRequest;
import com.example.kiosk.dto.PaymentResponse;
import com.example.kiosk.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentApiController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> pay(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.makePay(paymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PaymentResponse(payment));
    }
}
