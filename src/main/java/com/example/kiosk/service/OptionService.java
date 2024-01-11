package com.example.kiosk.service;

import com.example.kiosk.domain.menu.Menu;
import com.example.kiosk.domain.menu.MenuOption;
import com.example.kiosk.dto.SeeOptionOfMenuRequest;
import com.example.kiosk.repository.MenuOptionRepository;
import com.example.kiosk.repository.MenuRepository;
import com.example.kiosk.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OptionService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private MenuOptionRepository menuOptionRepository;


}
