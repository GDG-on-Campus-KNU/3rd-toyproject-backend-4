package com.example.kiosk.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItemOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OrderItemId")
    private OrderItem orderItem;

    private Long optionId;
    private String optionName;
    private BigDecimal optionPrice;


    @Builder
    public OrderItemOption(OrderItem orderItem, Long optionId, String optionName, BigDecimal optionPrice) {
        this.orderItem = orderItem;
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        orderItem.getOptions().add(this);
    }

}
