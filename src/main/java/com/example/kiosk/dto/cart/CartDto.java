package com.example.kiosk.dto.cart;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {
    private int cartTotalPrice;
    List<CartItemDto> cartDto;
}
