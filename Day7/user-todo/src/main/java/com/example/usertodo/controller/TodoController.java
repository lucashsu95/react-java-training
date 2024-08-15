package com.example.usertodo.controller;

import com.example.usertodo.dto.TodoWithUpdate;
import com.example.usertodo.dto.UserLoginInputs;
import com.example.usertodo.dto.UserWithInsert;
import com.example.usertodo.dto.UserWithUpdate;
import com.example.usertodo.model.Todo;
import com.example.usertodo.service.TodoService;
import com.example.usertodo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> insert(@Valid @RequestBody Todo todo,HttpServletRequest request) {
        return todoService.insert(todo,request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody TodoWithUpdate todo, HttpServletRequest request) {
        return todoService.update(id, todo, request);
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> destroy(@PathVariable Long id, HttpServletRequest request) {
         return todoService.destroy(id, request);
     }
}