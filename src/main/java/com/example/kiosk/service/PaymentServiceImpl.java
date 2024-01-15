package com.example.kiosk.service;

import com.example.kiosk.domain.order.Order;
import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.dto.PaymentRequest;
import com.example.kiosk.repository.OrderRepository;
import com.example.kiosk.repository.PaymentRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    @Override
    public Payment makePay(PaymentRequest paymentRequest, HttpSession session) {
        Order order = orderService.makeOrder(session);
        return paymentRepository.save(paymentRequest.toEntity(order));
    }
}
