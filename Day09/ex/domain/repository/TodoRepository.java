package ex.domain.repository;

import ex.domain.entity.Todo;
import ex.usecase.todo.dto.ListTodoOutput;

import java.util.Optional;

public interface TodoRepository {
    ListTodoOutput getAll();

    Optional<Todo> getById(int id);

    Todo create(Todo todo);

    Todo update(int id, Todo todo);

    Boolean delete(int id);
}