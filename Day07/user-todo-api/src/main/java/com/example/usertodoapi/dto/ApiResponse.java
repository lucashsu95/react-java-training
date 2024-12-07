package com.example.usertodoapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;

    private ApiResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, data, null));
    }

    public static ResponseEntity<?> success() {
        return ResponseEntity.ok(new ApiResponse<>(true, null, null));
    }

    public static <T> ResponseEntity<?> fail(String message, Integer statusCode) {
        HttpStatus status = HttpStatus.valueOf(statusCode);
        return ResponseEntity.status(status).body(new ApiResponse<>(false, null, message));
    }

    public static ResponseEntity<?> INVALID_LOGIN() {
        return fail("MSG_INVALID_LOGIN", 403);
    }

    public static ResponseEntity<?> USER_EXISTS() {
        return fail("MSG_USER_EXISTS", 409);
    }

    public static ResponseEntity<?> USER_NOT_EXISTS() {
        return fail("MSG_USER_NOT_EXISTS", 404);
    }

    public static ResponseEntity<?> INVALID_ACCESS_TOKEN() {
        return fail("MSG_INVALID_ACCESS_TOKEN", 401);
    }

    public static ResponseEntity<?> PERMISSION_DENY() {
        return fail("MSG_PERMISSION_DENY", 403);
    }

    public static ResponseEntity<?> MISSING_FIELD() {
        return fail("MSG_MISSING_FIELD", 400);
    }

    public static ResponseEntity<?> WRONG_DATA_TYPE() {
        return fail("MSG_WRONG_DATA_TYPE", 400);
    }

    public static ResponseEntity<?> TODO_NOT_EXISTS() {
        return fail("MSG_TODO_NOT_EXISTS", 404);
    }
}