package com.example.kiosk.dto;

import com.example.kiosk.domain.payment.Payment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaymentResponse {
    private Long cartId;
    private Long totalPrice;
    private String paymentMethod;

    @Builder
    public PaymentResponse(Payment payment) {
        this.cartId = payment.getOrder().getId();
        this.totalPrice = payment.getTotalPrice();
        this.paymentMethod = payment.getPaymentMethod().toString();
    }
}
