package com.example.usertodo.service;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.dto.*;
import com.example.usertodo.model.User;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CheckTokenValidator checkToken;
    @Autowired
    private CheckAdminValidator checkAdmin;

    public ResponseEntity<?> index() {
        return ApiResponse.success(userRepository.findAll());
    }

    public ResponseEntity<?> insert(UserWithInsert request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ApiResponse.USER_EXISTS();
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setNickname(request.getNickname());
        user.setType(User.UserType.valueOf(request.getType()));
        return ApiResponse.success(userRepository.save(user));
    }

    public ResponseEntity<?> update(Long id, UserWithUpdate userWithUpdate, HttpServletRequest request) {
        ResponseEntity<?> validationResponse = checkToken.validate(request);
        if (!validationResponse.getStatusCode().is2xxSuccessful()) { // 檢查是否成功
            return validationResponse;
        }

        User user = (User) validationResponse.getBody(); // 取得 User 物件
        System.out.println(user);
        ResponseEntity<?> checkAdminResponse = checkAdmin.validate(user);
        if (!checkAdminResponse.getStatusCode().is2xxSuccessful()) { // 檢查是否成功
            return checkAdminResponse;
        }

        return userRepository.findById(id)
                .map(existingUser -> {
                    if (userRepository.existsByEmailAndIdNot(userWithUpdate.getEmail(), id)) {
                        return ApiResponse.USER_EXISTS();
                    }
                    if (userWithUpdate.getEmail() != null) {
                        existingUser.setEmail(userWithUpdate.getEmail());
                    }
                    if (userWithUpdate.getNickname() != null) {
                        existingUser.setNickname(userWithUpdate.getNickname());
                    }
                    if (userWithUpdate.getType() != null) {
                        existingUser.setType(User.UserType.valueOf(userWithUpdate.getType()));
                    }
                    if (userWithUpdate.getPassword() != null) {
                        existingUser.setPasswordHash(passwordEncoder.encode(userWithUpdate.getPassword()));
                    }

                    return ApiResponse.success(userRepository.save(existingUser));
                })
                .orElse(ApiResponse.USER_NOT_EXISTS());
    }

    public ResponseEntity<?> destroy(Long id, HttpServletRequest request) {
        ResponseEntity<?> validationResponse = checkToken.validate(request);
        if (!validationResponse.getStatusCode().is2xxSuccessful()) { // 檢查是否成功
            return validationResponse;
        }

        User user = (User) validationResponse.getBody(); // 取得 User 物件
        
        ResponseEntity<?> checkAdminResponse = checkAdmin.validate(user);
        if (!checkAdminResponse.getStatusCode().is2xxSuccessful()) { // 檢查是否成功
            return checkAdminResponse;
        }

        Optional<User> userToDelete = userRepository.findById(id);
        if(userToDelete.isPresent()) {
            userRepository.delete(userToDelete.get());
            return ApiResponse.success();
        }
        return ApiResponse.USER_NOT_EXISTS();
    }

    public ResponseEntity<?> login(UserLoginInputs request) {
        return userRepository.findByEmail(request.getEmail())
                .map(user -> {
                    if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
                        return ApiResponse.INVALID_LOGIN();
                    }
                    String token = UUID.randomUUID().toString();
                    user.setAccess_token(token);
                    userRepository.save(user);

                    return ApiResponse.success(new UserWithToken(user));
                })
                .orElse(ApiResponse.INVALID_LOGIN());
    }

    @SuppressWarnings("null")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        ResponseEntity<?> validationResponse = checkToken.validate(request);
        if (!validationResponse.getStatusCode().is2xxSuccessful()) { // 檢查是否成功
            return validationResponse;
        }
        User user = (User) validationResponse.getBody(); // 取得 User 物件
        user.setAccess_token(null);
        userRepository.save(user);
        return ApiResponse.success();
    }

}

@Component
class PasswordEncoder {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encode(String password) {
        return encoder.encode(password);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}