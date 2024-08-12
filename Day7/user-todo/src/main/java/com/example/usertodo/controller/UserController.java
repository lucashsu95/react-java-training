package com.example.usertodo.controller;

import com.example.usertodo.model.User;
import com.example.usertodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity index() {
        return userService.index();
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable Long id) {
        return userService.destroy(id);
    }
}