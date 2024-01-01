package com.example.kiosk.dto;

import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.domain.menu.MenuCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddMenuRequest {

    private String name;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private Long categoryId;

    public Menu toEntity(MenuCategory category){
        return Menu.builder()
                .name(name)
                .price(price)
                .description(description)
                .imageUrl(imageUrl)
                .category(category)
                .build();
    }
}
