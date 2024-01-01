package com.example.kiosk.service;

import com.example.kiosk.domain.menu.MenuCategory;
import com.example.kiosk.dto.AddMenuCategoryRequest;
import com.example.kiosk.repository.MenuCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;

    public MenuCategory addMenuCategory(AddMenuCategoryRequest request){
        return menuCategoryRepository.save(request.toEntity());
    }
}
