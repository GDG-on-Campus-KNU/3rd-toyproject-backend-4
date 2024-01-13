package com.example.kiosk.domain.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자의 접근 권한을 protected로 제한하여 객체의 불변성을 보호
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "menu_name", length = 30, nullable = false, unique = true) // 메뉴 이름 중복 방지
    private String name; // 메뉴 이름

    @Column(name = "menu_price", nullable = false)
    private BigDecimal price; //메뉴 가격

    @Column(name = "menu_description", columnDefinition = "TEXT")
    private String description; // 메뉴 설명

    @Column(name = "menu_image", nullable = true)
    private String image;

    @JsonBackReference
    @ManyToOne  // 한 카테고리에 여러 메뉴가 속할 수 있으므로 다대일 관계
    @JoinColumn(name = "category_id", nullable = false)
    private MenuCategory category; // 메뉴 카테고리(FK)

    @Builder
    public Menu(String name, BigDecimal price, String description, String image, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }
    public String getImagePath() {
        return this.image;
    }


    public void setMenuImage(String encodedImage) {
        this.image = encodedImage;
    }
}
