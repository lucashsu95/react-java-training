package com.example.usertodoapi.service;

import com.example.usertodoapi.Repository.UserRepository;
import com.example.usertodoapi.dto.ApiResponse;
import com.example.usertodoapi.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class CheckTokenValidator {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> validate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null) {
            String[] token = header.split(" ");
            if (token.length == 2 && token[0].equals("Bearer")) {
                Optional<User> user = userRepository.findByAccessToken(token[1]);
                if (user.isPresent()) {
                    return ResponseEntity.ok(user.get());
                }
            }
        }
        return ApiResponse.INVALID_ACCESS_TOKEN();
    }
}