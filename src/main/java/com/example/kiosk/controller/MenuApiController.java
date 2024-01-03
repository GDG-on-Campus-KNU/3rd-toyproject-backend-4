package com.example.kiosk.controller;

import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.dto.AddMenuRequest;
import com.example.kiosk.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MenuApiController {

    private final MenuService menuService;

    @PostMapping("/api/menu")
    public ResponseEntity<Menu> addMenu(@RequestBody AddMenuRequest request){
        Menu newMenu = menuService.addMenu(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);


    }
}
