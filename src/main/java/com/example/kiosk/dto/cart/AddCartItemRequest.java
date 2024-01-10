package com.example.kiosk.dto.cart;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AddCartItemRequest {
    private Long menuId;
    private String menuName;
    private BigDecimal menuPrice;

    private Long[] optionId;
    private String[] optionName;
    private BigDecimal[] optionPrice;

    private int amount;

    public CartItemDto toEntity() {
        return CartItemDto.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .optionId(optionId)
                .optionName(optionName)
                .optionPrice(optionPrice)
                .amount(amount)
                .build();
    }
}
