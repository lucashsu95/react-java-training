package ex.domain.repository;

import ex.domain.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    List<Todo> getAll();

    Optional<Todo> getById(int id);

    void create(Todo todo);

    void update(int id, Todo todo);

    void delete(int id);
}