package com.example.kiosk.controller;

import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.domain.menu.MenuCategory;
import com.example.kiosk.service.MenuService;
import com.example.kiosk.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OptionApiController {

    private final OptionService optionService;
//
//    @GetMapping("/api/{menuName}/option")
//    public ResponseEntity
}
