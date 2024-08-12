package com.example.usertodo.service;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity index() {
        return ApiResponse.success(userRepository.findAll());
    }

    public ResponseEntity insert(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ApiResponse.USER_EXISTS();
        }
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ApiResponse.success(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public ResponseEntity update(Long id, User request) {
        Optional<User> isExistUser = findById(id);
        if (isExistUser.isEmpty()) {
            return ApiResponse.USER_NOT_EXISTS();
        }
        if (userRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
            return ApiResponse.USER_EXISTS();
        }

        User user = isExistUser.get();

        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getNickname() != null) {
            user.setNickname(request.getNickname());
        }
        if (request.getPassword() != null) {
            user.setPassword(PasswordEncoder.encode(request.getPassword()));
        }
        if (request.getType() != null) {
            user.setType(request.getType());
        }

        userRepository.save(user);
        return ApiResponse.success(user);
    }

    public ResponseEntity destroy(Long id) {
        Optional<User> isExistUser = findById(id);
        if (isExistUser.isEmpty()) {
            return ApiResponse.USER_NOT_EXISTS();
        }
        User user = isExistUser.get();
        userRepository.delete(user);
        return ApiResponse.success();
    }

}

class PasswordEncoder {
    public static String encode(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
