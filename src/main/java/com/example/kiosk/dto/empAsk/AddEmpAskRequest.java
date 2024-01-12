package com.example.kiosk.dto.empAsk;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddEmpAskRequest {
    private Long id;
    private String name;
    private int amount;

    public EmpAskDto toEntity() {
        return new EmpAskDto(id, name, amount);
    }
}
