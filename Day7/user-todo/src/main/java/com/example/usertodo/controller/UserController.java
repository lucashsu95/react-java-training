package com.example.usertodo.controller;

import com.example.usertodo.annotation.RequireToken;
import com.example.usertodo.dto.UserLoginInputs;
import com.example.usertodo.dto.UserWithInsert;
import com.example.usertodo.dto.UserWithUpdate;
import com.example.usertodo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return userService.index();
    }

    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody UserWithInsert user) {
        return userService.insert(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UserWithUpdate user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return userService.destroy(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginInputs user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    @RequireToken
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        return userService.logout(token);
    }
}