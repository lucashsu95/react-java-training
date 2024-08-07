package com.example.usertodo.utils;

import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.dto.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success() {
        return ResponseEntity.ok(ApiResponse.success());
    }

    public static ResponseEntity<ApiResponse<Object>> fail(ErrorCode errorCode, HttpStatus status) {
        return ResponseEntity.status(status).body(ApiResponse.fail(errorCode.getMessage()));
    }
}