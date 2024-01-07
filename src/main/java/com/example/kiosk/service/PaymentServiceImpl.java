package com.example.kiosk.service;

import com.example.kiosk.domain.cart.Cart;
import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.dto.PaymentRequest;
import com.example.kiosk.dto.PaymentResponse;
import com.example.kiosk.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    // TODO: 추후 CartRepository 구현
    private final CartRepository cartRepository;
    @Override
    public Payment makePay(PaymentRequest paymentRequest) {
        Cart cart = cartRepository.findById(paymentRequest.getCartId()).orElseThrow(
                () -> new NoSuchElementException("해당 장바구니가 존재하지 않습니다.")
        );
        return paymentRepository.save(paymentRequest.toEntity(cart));
    }
}
