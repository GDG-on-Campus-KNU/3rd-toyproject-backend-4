package com.example.kiosk.controller;

import com.example.kiosk.domain.order.Order;
import com.example.kiosk.dto.order.OrderDto;
import com.example.kiosk.service.OrderService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderApiController {
    private final OrderService orderService;
//    @PostMapping("/api/order")
//    public ResponseEntity<Order> makeOrder(HttpSession httpSession) {
//        Order order = orderService.makeOrder(httpSession);
//        return ResponseEntity.status(HttpStatus.CREATED).body(null);
//    }

    @GetMapping("/api/order")
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        List<OrderDto> orders = orderService.findAll();
        return ResponseEntity.ok()
                .body(orders);
    }
}
