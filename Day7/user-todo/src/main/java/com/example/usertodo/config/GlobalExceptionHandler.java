package com.example.usertodo.config;

import com.example.usertodo.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 處理 URL 參數缺失的情況
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParams() {
        return ApiResponse.MISSING_FIELD();
    }

    // 處理方法參數類型不匹配的情況
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch() {
        return ApiResponse.WRONG_DATA_TYPE();
    }

    // 處理請求體驗證失敗的情況
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions() {
        return ApiResponse.MISSING_FIELD();
    }

    // 處理約束違反的情況
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException() {
        return ApiResponse.WRONG_DATA_TYPE();
    }
}