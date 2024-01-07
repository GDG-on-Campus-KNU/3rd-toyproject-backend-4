package com.example.kiosk.service;

import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.repository.MenuOptionRepository;
import com.example.kiosk.repository.MenuRepository;
import com.example.kiosk.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private MenuOptionRepository menuOptionRepository;
}
