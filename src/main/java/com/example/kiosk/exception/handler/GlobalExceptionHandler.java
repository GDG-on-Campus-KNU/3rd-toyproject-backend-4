package com.example.kiosk.exception.handler;

import com.example.kiosk.exception.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 유효하지 않은 결제수단을 입력 받을 경우
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final ErrorResult errorResult = ErrorResult.builder()
                .code("MethodArgumentNotValidException")
                .message(e.getBindingResult().getFieldError().getDefaultMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
