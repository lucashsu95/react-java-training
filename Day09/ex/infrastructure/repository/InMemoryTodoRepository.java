package ex.infrastructure.repository;

import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTodoRepository implements TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    @Override
    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }

    @Override
    public Optional<Todo> getById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    @Override
    public void create(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void update(int id, Todo todo) {
        getById(id).ifPresent(existingTodo -> {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setCompleted(todo.isCompleted());
        });
    }

    @Override
    public void delete(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
