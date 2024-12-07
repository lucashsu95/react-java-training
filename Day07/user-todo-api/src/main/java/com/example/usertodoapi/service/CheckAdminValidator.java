package com.example.usertodoapi.service;

import com.example.usertodoapi.dto.ApiResponse;
import com.example.usertodoapi.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CheckAdminValidator {

    public ResponseEntity<?> validate(User user) {
        if (user.getType() == User.UserType.ADMIN) {
            return ResponseEntity.ok(user);
        }
        return ApiResponse.PERMISSION_DENY();
    }
}