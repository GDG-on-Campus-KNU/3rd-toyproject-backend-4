package com.example.kiosk.controller;

import com.example.kiosk.domain.empAsk.EmpAsk;
import com.example.kiosk.dto.empAsk.AddEmpAskRequest;
import com.example.kiosk.dto.empAsk.EmpAskListDto;
import com.example.kiosk.service.EmpAskService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmpAskApiController {
    private final EmpAskService empAskService;
    public static final String EmpAsk_SessionKey = "empAsk";

    @PostMapping("/api/customer/request")
    public ResponseEntity<EmpAskListDto> addEmpAsk(@RequestBody AddEmpAskRequest request, HttpSession session) {
        EmpAskListDto empAskListDto = empAskService.addEmpAsk(request, session);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empAskListDto);
    }

    @GetMapping("/api/requests")
    public ResponseEntity<List<EmpAsk>> findAllEmpAsks() {
        List<EmpAsk> empAsks = empAskService.findAll();

        return ResponseEntity.ok()
                .body(empAsks);
    }

    @GetMapping("/api/customer/request")
    public ResponseEntity<EmpAskListDto> returnEmpAskList(HttpSession session) {
        EmpAskListDto empAskListDto = (EmpAskListDto) session.getAttribute(EmpAsk_SessionKey);
        if(empAskListDto == null) {
            return null;
        }

        return ResponseEntity.ok()
                .body(empAskListDto);
    }
}