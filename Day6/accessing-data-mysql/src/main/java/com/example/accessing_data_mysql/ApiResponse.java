package com.example.accessing_data_mysql;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;

    // Constructors, Getters and Setters

    public ApiResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(boolean success, T data) {
        this(success, data, null);
    }

    public ApiResponse(boolean success, String message) {
        this(success, null, message);
    }

    public ApiResponse(boolean success) {
        this(success, null, null);
    }

    // Getters and Setters
}
