package com.example.usertodoapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.usertodoapi.dto.ApiResponse;
import com.example.usertodoapi.model.Todo;
import com.example.usertodoapi.model.User;
import com.example.usertodoapi.model.User.UserType;

@Component
public class CheckTodoPermission {
    public ResponseEntity<?> validate(User user, Todo todo) {
        if (user.getId() == todo.getUser().getId() || user.getType().equals(UserType.ADMIN)) {
            return ResponseEntity.ok(todo);
        }
        return ApiResponse.TODO_NOT_EXISTS();
    }
}
