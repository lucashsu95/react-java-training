package com.example.usertodo.dto;

public enum ErrorCode {
    INVALID_LOGIN("MSG_INVALID_LOGIN"),
    USER_EXISTS("MSG_USER_EXISTS"),
    INVALID_ACCESS_TOKEN("MSG_INVALID_ACCESS_TOKEN"),
    PERMISSION_DENY("MSG_PERMISSION_DENY"),
    MISSING_FIELD("MSG_MISSING_FIELD"),
    WRONG_DATA_TYPE("MSG_WRONG_DATA_TYPE");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}