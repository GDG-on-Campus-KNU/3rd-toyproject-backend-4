package com.example.kiosk.domain.option;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "option_name", length = 30, nullable = false, unique = true)
    private String name; // 옵션 이름

    @Column(name = "option_price", nullable = false)
    private BigDecimal price; //옵션 가격

    @Column(name = "option_imageurl", columnDefinition = "TEXT")
    private String imageUrl; // 메뉴 이미지 url

    @Builder
    public Option(String name, BigDecimal price, String imageUrl){
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

