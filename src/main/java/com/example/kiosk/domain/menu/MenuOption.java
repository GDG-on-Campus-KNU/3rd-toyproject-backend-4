package com.example.kiosk.domain.menu;

import com.example.kiosk.domain.option.Option;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "menu_option")
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_option_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu; // 메뉴 id(FK)

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option; // 옵션 id(FK)
}
