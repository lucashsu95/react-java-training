package com.example.accessing_data_mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.accessing_data_mysql.ApiResponse;
// import com.example.accessing_data_mysql.exception.UserException;
import com.example.accessing_data_mysql.model.User;
import com.example.accessing_data_mysql.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody @Validated User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(new ApiResponse<>(true, createdUser));
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<ApiResponse<User>> getUser(@PathVariable Long id) {
    //     User user = userService.getUser(id);
    //     return ResponseEntity.ok(new ApiResponse<>(true, user));
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    //     User updatedUser = userService.updateUser(id, userDetails);
    //     return ResponseEntity.ok(new ApiResponse<>(true, updatedUser));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
    //     userService.deleteUser(id);
    //     return ResponseEntity.ok(new ApiResponse<>(true));
    // }

    // @ExceptionHandler(UserException.class)
    // public ResponseEntity<ApiResponse<String>> handleUserException(UserException ex) {
    //     return ResponseEntity
    //             .status(HttpStatus.BAD_REQUEST)
    //             .body(new ApiResponse<>(false, ex.getMessage()));
    // }
}
