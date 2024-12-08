package ex.usecase.todo;

import ex.domain.repository.TodoRepository;

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