package com.example.kiosk.dto.order;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemOptionDto {
    private Long optionId;
    private String optionName;
    private BigDecimal optionPrice;
}
