package com.example.usertodoapi.controller;

import com.example.usertodoapi.dto.UserLoginInputs;
import com.example.usertodoapi.dto.UserWithInsert;
import com.example.usertodoapi.dto.UserWithUpdate;
import com.example.usertodoapi.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> index() {
        return userService.index();
    }

    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody UserWithInsert user) {
        return userService.insert(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UserWithUpdate user,
            HttpServletRequest request) {
        return userService.update(id, user, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id, HttpServletRequest request) {
        return userService.destroy(id, request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginInputs user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        return userService.logout(request);
    }
}