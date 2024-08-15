package com.example.usertodo.service;

import com.example.usertodo.Repository.TodoRepository;
import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.model.Todo;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CheckTodoExists {
    @Autowired
    private TodoRepository todoRepository;
    
    public ResponseEntity<?> validate(Long id, HttpServletRequest request) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        }
        return ApiResponse.TODO_NOT_EXISTS();
    }   
}
