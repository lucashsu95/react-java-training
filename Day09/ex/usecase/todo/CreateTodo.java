package ex.usecase.todo;

import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;

public class CreateTodo implements CreateTodoUsecase {
    private final TodoRepository repo;

    public CreateTodo(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Todo execute(Todo todo) throws Exception {
        TodoValidator.validate(todo);
        Todo output = repo.create(todo);
        return output;
    }
}