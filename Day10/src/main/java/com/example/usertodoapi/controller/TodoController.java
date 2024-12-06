package com.example.usertodoapi.controller;

import com.example.usertodoapi.dto.TodoWithUpdate;
import com.example.usertodoapi.model.Todo;
import com.example.usertodoapi.service.TodoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public ResponseEntity<?> index(HttpServletRequest request) {
        return todoService.index(request);
    }

    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody Todo todo, HttpServletRequest request) {
        return todoService.insert(todo, request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody TodoWithUpdate todo,
            HttpServletRequest request) {
        return todoService.update(id, todo, request);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> destroy(@PathVariable Long id, HttpServletRequest request) {
        return todoService.destroy(id, request);
    }
}