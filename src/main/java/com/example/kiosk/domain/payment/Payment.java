
package com.example.kiosk.domain.payment;

import com.example.kiosk.domain.order.Order;
import com.example.kiosk.types.PaymentMethod;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long totalPrice;
    private PaymentMethod paymentMethod;

    @Builder
    public Payment(Order order, Long totalPrice, PaymentMethod paymentMethod) {
        this.order = order;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }
}

