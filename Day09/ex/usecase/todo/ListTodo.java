package ex.usecase.todo;

import ex.domain.repository.TodoRepository;
import ex.usecase.todo.dto.ListTodoOutput;

public class ListTodo implements ListTodoUsecase {
    private final TodoRepository repo;

    public ListTodo(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public ListTodoOutput execute() {
        ListTodoOutput todos = repo.getAll();
        return todos;
    }
}