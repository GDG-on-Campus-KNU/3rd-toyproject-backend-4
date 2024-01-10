package com.example.kiosk.dto.cart;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
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

    private BigDecimal totalPrice;

    public void totalPriceCalc() {
        BigDecimal total = BigDecimal.ZERO;
        if(optionPrice != null) {
            for(BigDecimal price : optionPrice) {
                total = total.add(price);
            }

        }
        this.totalPrice = total.add(menuPrice)
                .multiply(BigDecimal.valueOf(amount));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(optionId);
        result = prime * result + Arrays.hashCode(optionName);
        result = prime * result + Arrays.hashCode(optionPrice);
        result = prime * result + Objects.hash(menuId, menuName, menuPrice);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        CartItemDto other = (CartItemDto) obj;
        return menuId == other.menuId &&
                Objects.equals(menuName, other.menuName) &&
                menuPrice.equals(other.menuPrice) &&
                Arrays.equals(optionId, other.optionId) &&
                Arrays.equals(optionName, other.optionName) &&
                Arrays.equals(optionPrice, other.optionPrice);
    }
}
