package com.example.usertodo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.Todo;
import com.example.usertodo.model.User;
import com.example.usertodo.model.User.UserType;

@Component
public class CheckTodoPermission {
    public ResponseEntity<?> validate(User user, Todo todo) {
        if (user.getId() == todo.getUser().getId() || user.getType().equals(UserType.ADMIN)) {
            return ResponseEntity.ok(todo);
        }
        return ApiResponse.TODO_NOT_EXISTS();
    }
}
