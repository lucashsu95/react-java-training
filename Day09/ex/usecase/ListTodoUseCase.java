
package ex.usecase;

import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;

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