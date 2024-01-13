package com.example.kiosk.repository;

import com.example.kiosk.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.domain.menu.MenuOption;

import java.util.List;

public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {

    List<MenuOption> findByMenu(Menu menu);
}
