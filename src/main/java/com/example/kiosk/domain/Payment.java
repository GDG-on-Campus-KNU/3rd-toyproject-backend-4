//package com.example.kiosk.domain;
//
//import com.example.kiosk.types.PaymentMethod;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class Payment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "payment_id")
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//    private Long totalPrice;
//    private PaymentMethod paymentMethod;
//
//    @Builder
//    public Payment(Cart cart, Long totalPrice, PaymentMethod paymentMethod) {
//        this.cart = cart;
//        this.totalPrice = totalPrice;
//        this.paymentMethod = paymentMethod;
//    }
//}
