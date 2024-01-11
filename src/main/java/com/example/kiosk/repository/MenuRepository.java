package com.example.kiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.domain.menu.Menu;

import java.util.List;

//리포지토리 => DB 와 APP 의 브릿지 역할, 데이터에 대한 CRUD 수행 가능
public interface MenuRepository extends JpaRepository<Menu, Long> {

    //Spring Data JPA의 Query Method 기능을 활용해
    //메서드 이름만으로도 JPA가 어떤 쿼리를 수행해야 하는지를 인지하고, 이를 SQL로 변환해서 데이터베이스에 요청
    List<Menu> findByCategoryName(String categoryName);

    Menu findByName(String name);
}