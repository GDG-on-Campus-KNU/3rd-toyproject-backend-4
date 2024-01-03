package com.example.kiosk.domain.menu;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "menucategory")
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menucategory_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "menucategory_name", length = 30, nullable = false)
    private String name; // 메뉴 카테고리 이름

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)  // 카테고리를 삭제하면 메뉴들도 삭제되도록..
    private List<Menu> menus = new ArrayList<>(); //이 카테고리에 속한 메뉴들

    @Builder
    public MenuCategory(String name, List<Menu> menus) {
        this.name = name;
        this.menus = menus;
    }
}
