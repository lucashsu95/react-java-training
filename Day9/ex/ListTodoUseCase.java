package com.example.domain.usecase;

import com.example.domain.entity.Todo;
import com.example.domain.repository.TodoRepository;

import java.util.List;

public class ListTodoUseCase {
    private final TodoRepository repository;

    public ListTodoUseCase(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> execute() {
        return repository.getAll();
    }
}
