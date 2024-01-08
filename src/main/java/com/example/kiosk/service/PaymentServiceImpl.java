package com.example.kiosk.service;

import com.example.kiosk.domain.order.Order;
import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.dto.PaymentRequest;
import com.example.kiosk.repository.OrderRepository;
import com.example.kiosk.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    @Override
    public Payment makePay(PaymentRequest paymentRequest) {
        Order order = orderRepository.findById(paymentRequest.getOrderId()).orElseThrow(
                () -> new NoSuchElementException("해당 주문이 존재하지 않습니다.")
        );
        return paymentRepository.save(paymentRequest.toEntity(order));
    }
}
