package com.example.kiosk.dto.empAsk;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpAskListDto {
    List<EmpAskDto> requests;
}
