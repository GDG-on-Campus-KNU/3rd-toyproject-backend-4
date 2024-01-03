package com.example.kiosk.dto;

import com.example.kiosk.domain.menu.MenuCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddMenuCategoryRequest {

    private String name;

    public MenuCategory toEntity(){
        return MenuCategory.builder()
                .name(name)
                .build();
    }
}