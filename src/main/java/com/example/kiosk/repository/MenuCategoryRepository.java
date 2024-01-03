package com.example.kiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.domain.menu.MenuCategory;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

}
