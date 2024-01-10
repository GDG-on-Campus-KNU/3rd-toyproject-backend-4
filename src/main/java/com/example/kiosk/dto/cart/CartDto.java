package com.example.kiosk.dto.cart;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {
    private BigDecimal cartTotalPrice;
    List<CartItemDto> cartItems;
}
