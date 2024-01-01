package com.example.kiosk.controller;

import com.example.kiosk.domain.menu.MenuCategory;
import com.example.kiosk.dto.AddMenuCategoryRequest;
import com.example.kiosk.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MenuCategoryApiController {
    private final MenuCategoryService menucategoryService;

    @PostMapping("/api/menucategory")
    public ResponseEntity<MenuCategory> addMenuCategory(@RequestBody AddMenuCategoryRequest request){
        MenuCategory newMenuCategory = menucategoryService.addMenuCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenuCategory);
    }
}
