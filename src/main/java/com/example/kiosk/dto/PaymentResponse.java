package com.example.kiosk.dto;

import com.example.kiosk.domain.payment.Payment;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaymentResponse {
    private Long orderId;
    private BigDecimal totalPrice;
    private String paymentMethod;

    @Builder
    public PaymentResponse(Payment payment) {
        this.orderId = payment.getOrder().getId();
        this.totalPrice = payment.getTotalPrice();
        this.paymentMethod = payment.getPaymentMethod().toString();
    }
}
