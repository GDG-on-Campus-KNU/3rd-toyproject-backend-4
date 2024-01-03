package com.example.kiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.domain.menu.MenuOption;

public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {

}
