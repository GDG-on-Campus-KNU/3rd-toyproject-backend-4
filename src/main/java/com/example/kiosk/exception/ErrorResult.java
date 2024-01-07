package com.example.kiosk.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResult {
    private String code;
    private String message;
}
