package com.example.kiosk.service;

import com.example.kiosk.controller.EmpAskApiController;
import com.example.kiosk.domain.empAsk.EmpAsk;
import com.example.kiosk.dto.empAsk.AddEmpAskRequest;
import com.example.kiosk.dto.empAsk.EmpAskDto;
import com.example.kiosk.dto.empAsk.EmpAskListDto;
import com.example.kiosk.dto.empAsk.UpdateEmpAskRequest;
import com.example.kiosk.repository.EmpAskRepository;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmpAskService {
    @Autowired
    private final EmpAskRepository empAskRepository;
    private final String empAskSessionKey = EmpAskApiController.EmpAsk_SessionKey;
    public EmpAskListDto addEmpAsk(AddEmpAskRequest request, HttpSession session) {
        EmpAskListDto empAskListDto = (EmpAskListDto) session.getAttribute(empAskSessionKey);

        EmpAskDto requestedAsk = request.toEntity();

        if(empAskListDto == null) {
            List<EmpAskDto> newAskList = new ArrayList<>();
            newAskList.add(requestedAsk);
            empAskListDto = new EmpAskListDto(newAskList);
        } else {
            List<EmpAskDto> existAsks = empAskListDto.getRequests();

            if(existAsks.contains(requestedAsk)) {
                int index = existAsks.indexOf(requestedAsk);
                int amount = requestedAsk.getAmount();

                EmpAskDto existAsk = existAsks.get(index);
                int newAmount = existAsk.getAmount() + amount;

                existAsk.setAmount(newAmount);
                existAsks.set(index, existAsk);
            } else {
                existAsks.add(requestedAsk);
            }
        }

        session.setAttribute(empAskSessionKey, empAskListDto);

        return empAskListDto;
    }

    public List<EmpAsk> findAll() {
        return empAskRepository.findAll();
    }

    public void deleteOneAsk(int index, HttpSession session) {
        EmpAskListDto empAskListDto = (EmpAskListDto) session.getAttribute(empAskSessionKey);
        List<EmpAskDto> empAsks = empAskListDto.getRequests();

        empAsks.remove(index);

        if(empAsks.size() == 0) {
            session.removeAttribute(empAskSessionKey);
        }
    }

    public EmpAskListDto updateAskAmount(int index, UpdateEmpAskRequest request, HttpSession session) {
        EmpAskListDto empAskListDto = (EmpAskListDto) session.getAttribute(empAskSessionKey);
        List<EmpAskDto> empAskDtos = empAskListDto.getRequests();
        EmpAskDto empAskDto = empAskDtos.get(index);

        int newAmount = empAskDto.getAmount() + request.getAmount();

        if(newAmount <= 0) {
            deleteOneAsk(index, session);
        }

        empAskDto.setAmount(newAmount);

        return empAskListDto;
    }
}
