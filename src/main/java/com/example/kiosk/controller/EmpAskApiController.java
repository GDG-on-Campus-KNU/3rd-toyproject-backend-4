package com.example.kiosk.controller;

import com.example.kiosk.dto.empAsk.AddEmpAskRequest;
import com.example.kiosk.dto.empAsk.EmpAskListDto;
import com.example.kiosk.service.EmpAskService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmpAskApiController {
    private final EmpAskService empAskService;
    public static final String EmpAsk_SessionKey = "empAsk";

    @PostMapping("/api/request")
    public ResponseEntity<EmpAskListDto> addEmpAsk(@RequestBody AddEmpAskRequest request, HttpSession session) {
        EmpAskListDto empAskListDto = empAskService.addEmpAsk(request, session);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empAskListDto);
    }
}
