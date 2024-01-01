package com.example.kiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.domain.menu.Menu;

//리포지토리 => DB 와 APP 의 브릿지 역할, 데이터에 대한 CRUD 수행 가능
public interface MenuRepository extends JpaRepository<Menu, Long> {

}