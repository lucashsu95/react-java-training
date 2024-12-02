package com.example.domain.repository;

import com.example.domain.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    List<Todo> getAll();
    Optional<Todo> getById(int id);
    void create(Todo todo);
    void update(int id, Todo todo);
    void delete(int id);
}
