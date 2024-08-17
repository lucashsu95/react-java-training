package com.example.usertodoapi.service;

import com.example.usertodoapi.Repository.TodoRepository;
import com.example.usertodoapi.dto.ApiResponse;
import com.example.usertodoapi.dto.TodoWithUpdate;
import com.example.usertodoapi.model.Todo;
import com.example.usertodoapi.model.User;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    CheckTokenValidator CheckToken;
    @Autowired
    CheckTodoExists todoExists;
    @Autowired
    CheckTodoPermission todoPermission;

    public ResponseEntity<?> index(HttpServletRequest request) {
        ResponseEntity<?> res = CheckToken.validate(request);
        if (!res.getStatusCode().is2xxSuccessful()) {
            return ApiResponse.INVALID_ACCESS_TOKEN();
        }

        User user = (User) res.getBody();
        Iterable<Todo> usertodoapis = todoRepository.findByUser(user);
        return ApiResponse.success(usertodoapis);
    }

    public ResponseEntity<?> insert(Todo todo, HttpServletRequest request) {
        ResponseEntity<?> res = CheckToken.validate(request);
        if (!res.getStatusCode().is2xxSuccessful()) {
            return ApiResponse.INVALID_ACCESS_TOKEN();
        }

        User user = (User) res.getBody();
        todo.setUser(user);
        Todo savedTodo = todoRepository.save(todo);

        return ApiResponse.success(savedTodo);
    }

    public ResponseEntity<?> update(Long id, TodoWithUpdate todoWithUpdate, HttpServletRequest request) {
        ResponseEntity<?> res = CheckToken.validate(request);
        if (!res.getStatusCode().is2xxSuccessful()) {
            return ApiResponse.INVALID_ACCESS_TOKEN();
        }
        User user = (User) res.getBody();

        ResponseEntity<?> res2 = todoExists.validate(id, request);
        if (!res2.getStatusCode().is2xxSuccessful())
            return res2;
        Todo todo = (Todo) res2.getBody();

        ResponseEntity<?> res3 = todoPermission.validate(user, todo);
        if (!res3.getStatusCode().is2xxSuccessful())
            return res3;

        if (todoWithUpdate.getCompleted() != null) {
            todo.setCompleted(todoWithUpdate.getCompleted());
        }
        if (todoWithUpdate.getTitle() != null) {
            todo.setTitle(todoWithUpdate.getTitle());
        }
        if (todoWithUpdate.getContent() != null) {
            todo.setContent(todoWithUpdate.getContent());
        }
        return ApiResponse.success(todoRepository.save(todo));
    }

    public ResponseEntity<?> destroy(Long id, HttpServletRequest request) {
        ResponseEntity<?> res = CheckToken.validate(request);
        if (!res.getStatusCode().is2xxSuccessful()) {
            return ApiResponse.INVALID_ACCESS_TOKEN();
        }
        User user = (User) res.getBody();

        ResponseEntity<?> res2 = todoExists.validate(id, request);
        if (!res2.getStatusCode().is2xxSuccessful()) {
            return res2;
        }
        Todo todo = (Todo) res2.getBody();

        ResponseEntity<?> res3 = todoPermission.validate(user, todo);
        if (!res3.getStatusCode().is2xxSuccessful()) {
            return res3;
        }
        todoRepository.delete(todo);
        return ApiResponse.success();
    }
}