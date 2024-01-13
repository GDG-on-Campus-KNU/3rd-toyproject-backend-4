package com.example.kiosk.dto;

import java.math.BigDecimal;

public class SeeOptionOfMenuRequest {
    private String name;
    private BigDecimal price;
    private String image;

    public SeeOptionOfMenuRequest(String name, BigDecimal price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
