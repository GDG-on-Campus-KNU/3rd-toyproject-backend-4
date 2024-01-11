package com.example.kiosk.dto.order;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private BigDecimal totalPrice;
    private List<OrderItemDto> items;
}
