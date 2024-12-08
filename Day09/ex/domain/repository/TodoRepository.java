package ex.domain.repository;

import ex.domain.entity.Todo;
import ex.usecase.todo.ListTodoOutput;

import java.util.Optional;

public interface TodoRepository {
    ListTodoOutput getAll();

    Optional<Todo> getById(int id);

    Todo create(Todo todo);

    void update(int id, Todo todo);

    void delete(int id);
}