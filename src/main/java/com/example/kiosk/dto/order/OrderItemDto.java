package com.example.kiosk.dto.order;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private Long orderItemId;
    private Long menuId;
    private String menuName;
    private BigDecimal menuPrice;
    private List<OrderItemOptionDto> options;
    private BigDecimal itemTotalPrice;
    private int amount;

}
