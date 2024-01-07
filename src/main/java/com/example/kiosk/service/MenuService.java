package com.example.kiosk.service;


import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.domain.menu.MenuCategory;
import com.example.kiosk.dto.AddMenuRequest;
import com.example.kiosk.repository.MenuCategoryRepository;
import com.example.kiosk.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;


//    public Menu addMenu(AddMenuRequest request) {
//        MenuCategory category = menuCategoryRepository.findById(request.getCategoryId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + request.getCategoryId()));
//        Menu menu = request.toEntity(category);
//        return menuRepository.save(menu);
//
//    }

    public List<Menu> seeAllMenus() {
        return menuRepository.findAll();
    }

    public List<MenuCategory> getMenusByCategory() {
        // 모든 메뉴 가져오기
        List<Menu> menus = menuRepository.findAll();

        // 카테고리별로 메뉴를 분류하기 위한 Map 생성
        Map<String, MenuCategory> categoryMap = new HashMap<>();

        // 각 메뉴를 카테고리별로 분류
        for (Menu menu : menus) {
            Long categoryId = menu.getCategory().getId();
            String categoryName = menu.getCategory().getName();
            MenuCategory category = categoryMap.get(categoryName);

            if (category == null) {
                category = new MenuCategory();
                category.setId(categoryId);
                category.setName(categoryName);
                category.setMenus(new ArrayList<>());
                categoryMap.put(categoryName, category);
            }

            category.getMenus().add(menu);
        }

        // 생성된 카테고리 목록 반환
        return new ArrayList<>(categoryMap.values());
    }

    public List<Menu> getMenusByCategoryName(String categoryName) {
        return menuRepository.findByCategoryName(categoryName);
    }

}
