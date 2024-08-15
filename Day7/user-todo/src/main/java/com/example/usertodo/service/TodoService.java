package com.example.usertodo.service;

import com.example.usertodo.Repository.TodoRepository;
import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.dto.TodoWithUpdate;
import com.example.usertodo.model.Todo;
import com.example.usertodo.model.User;

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
        Iterable<Todo> userTodos = todoRepository.findByUser(user);
        return ApiResponse.success(userTodos);
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