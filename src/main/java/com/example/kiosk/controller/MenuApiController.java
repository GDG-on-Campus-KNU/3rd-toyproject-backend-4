package com.example.kiosk.controller;

import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.domain.menu.MenuCategory;
import com.example.kiosk.dto.AddMenuRequest;
import com.example.kiosk.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MenuApiController {

    private final MenuService menuService;

    //get 요청을 받으면 모든 카테고리와 해당 카테고리의 메뉴들을 response
    @GetMapping("/menus/seeAll")
    public ResponseEntity<List<MenuCategory>> getMenusByCategory() {
        List<MenuCategory> categories = menuService.getMenusByCategory();
        return ResponseEntity.ok(categories);
    }

    //카테고리 이름이 담긴 get 요청을 받으면
    //해당 카테고리의 메뉴들을 반환함
    @GetMapping("/menus/{categoryName}")
    public ResponseEntity<List<Menu>> getMenusByCategoryName(@PathVariable String categoryName) {
        List<Menu> menus = menuService.getMenusByCategoryName(categoryName);
        return ResponseEntity.ok(menus);
    }



}
