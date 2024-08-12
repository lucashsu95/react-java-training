package com.example.usertodo.service;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> index() {
        return ApiResponse.success(userRepository.findAll());
    }

    public ResponseEntity<?> insert(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ApiResponse.USER_EXISTS();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ApiResponse.success(userRepository.save(user));
    }

    public ResponseEntity<?> update(Long id, User request) {
        return userRepository.findById(id)
                .map(user -> {
                    if (userRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
                        return ApiResponse.USER_EXISTS();
                    }
                    updateUserFields(user, request);
                    return ApiResponse.success(userRepository.save(user));
                })
                .orElse(ApiResponse.USER_NOT_EXISTS());
    }

    public ResponseEntity<?> destroy(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ApiResponse.success();
                })
                .orElse(ApiResponse.USER_NOT_EXISTS());
    }

    private void updateUserFields(User user, User request) {
        Optional.ofNullable(request.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(request.getNickname()).ifPresent(user::setNickname);
        Optional.ofNullable(request.getPassword()).ifPresent(password -> user.setPassword(passwordEncoder.encode(password)));
        Optional.ofNullable(request.getType()).ifPresent(user::setType);
    }
}

@Component
class PasswordEncoder {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encode(String password) {
        return encoder.encode(password);
    }
}