package com.example.usertodoapi.service;

import com.example.usertodoapi.Repository.TodoRepository;
import com.example.usertodoapi.Repository.UserRepository;
import com.example.usertodoapi.dto.*;
import com.example.usertodoapi.model.User;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Added this import

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
    @Autowired
    private TodoRepository todoRepository;

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

                    return ApiResponse.success(userRepository.save(existingUser));
                })
                .orElse(ApiResponse.USER_NOT_EXISTS());
    }

    @Transactional // Added this annotation to ensure transactional management
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
        if (userToDelete.isPresent()) {
            User userEntity = userToDelete.get();
            todoRepository.deleteByUser(userEntity);
            userRepository.delete(userEntity);
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