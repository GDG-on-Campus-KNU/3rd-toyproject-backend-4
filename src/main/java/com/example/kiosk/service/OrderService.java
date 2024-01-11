package com.example.kiosk.service;

import com.example.kiosk.controller.CartApiController;
import com.example.kiosk.domain.order.Order;
import com.example.kiosk.domain.order.OrderItem;
import com.example.kiosk.domain.order.OrderItemOption;
import com.example.kiosk.dto.cart.CartDto;
import com.example.kiosk.dto.cart.CartItemDto;
import com.example.kiosk.repository.OrderRepository;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public Order makeOrder(HttpSession session) {
        CartDto cartDto = (CartDto) session.getAttribute(CartApiController.Cart_Session_Key);
        Order newOrder = Order.builder()
                .totalPrice(cartDto.getCartTotalPrice())
                .build();

        List<CartItemDto> cartItems = cartDto.getCartItems();
        for(CartItemDto item : cartItems) {
            OrderItem newItem = OrderItem.builder()
                    .order(newOrder)
                    .menuId(item.getMenuId())
                    .menuName(item.getMenuName())
                    .menuPrice(item.getMenuPrice())
                    .itemTotalPrice(item.getTotalPrice())
                    .amount(item.getAmount())
                    .build();

            for(int i = 0; i < item.getOptionId().length; i++) {
                OrderItemOption newItemOption = OrderItemOption.builder()
                        .orderItem(newItem)
                        .optionId(item.getOptionId()[i])
                        .optionName(item.getOptionName()[i])
                        .optionPrice(item.getOptionPrice()[i])
                        .build();
            }
        }

        return orderRepository.save(newOrder);
    }
}
