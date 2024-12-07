package com.example.usertodoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.usertodoapi.usecase.ListUserUseCase;
import com.example.usertodoapi.domain.entity.User;
import com.example.usertodoapi.interfaces.presenter.UserPresenter;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final ListUserUseCase listUserUseCase;
    private final UserPresenter userPresenter;
    
    @Autowired
    public UserController(ListUserUseCase listUserUseCase, UserPresenter userPresenter) {
        this.listUserUseCase = listUserUseCase;
        this.userPresenter = userPresenter;
    }

    @GetMapping
    public UserPresenter.ListUserResponse getAll() {
        try {
            List<User> users = listUserUseCase.execute();
            return userPresenter.success(users);
        } catch (Exception e) {
            return userPresenter.error(e.getMessage());
        }
    }

    // @GetMapping("/{id}")
    // public String getById(@PathVariable int id) {
    //     return "Get user by id: " + id;
    // }

    // @PostMapping
    // public String create() {
    //     return "Create user";
    // }

    // @PutMapping("/{id}")
    // public String update(@PathVariable int id) {
    //     return "Update user by id: " + id;
    // }

    // @DeleteMapping("/{id}")
    // public String delete(@PathVariable int id) {
    //     return "Delete user by id: " + id;
    // }

}