package com.example.kiosk.dto.cart;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CartItemDto {

    private Long menuId;
    private String menuName;
    private BigDecimal menuPrice;

    private Long[] optionId;
    private String[] optionName;
    private BigDecimal[] optionPrice;

    private int amount;

}
