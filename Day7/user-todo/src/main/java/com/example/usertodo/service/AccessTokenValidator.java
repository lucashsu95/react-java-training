package com.example.usertodo.service;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class AccessTokenValidator {

    private final UserRepository userRepository;

    public AccessTokenValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> validate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null) {
            String[] token = header.split(" ");
            if (token.length == 2 && token[0].equals("Bearer")) {
                Optional<User> user = userRepository.findByAccessToken(token[1]);
                if(user.isPresent()) {
                    return ResponseEntity.ok(user.get());
                }
            }
        }
        return ApiResponse.INVALID_ACCESS_TOKEN();
    }
}