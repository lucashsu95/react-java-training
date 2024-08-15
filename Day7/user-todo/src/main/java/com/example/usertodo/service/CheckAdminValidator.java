package com.example.usertodo.service;

import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.User;
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