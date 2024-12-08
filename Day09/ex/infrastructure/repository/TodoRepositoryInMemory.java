package ex.infrastructure.repository;

import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;
import ex.usecase.todo.dto.ListTodoOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoRepositoryInMemory implements TodoRepository {
    private final List<Todo> todos = new ArrayList<>();
    private static int currentId = 1;

    @Override
    public ListTodoOutput getAll() {
        return new ListTodoOutput(new ArrayList<>(todos));
    }

    @Override
    public Optional<Todo> getById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    @Override
    public Todo create(Todo todo) {
        todo.setId(currentId++);
        todos.add(todo);
        return todo;
    }

    @Override
    public Todo update(int id, Todo todo) {
        getById(id).ifPresent(existingTodo -> {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setCompleted(todo.isCompleted());
        });
        return todo;
    }

    @Override
    public Boolean delete(int id) {
        todos.removeIf(todo -> todo.getId() == id);
        return true;
    }
}