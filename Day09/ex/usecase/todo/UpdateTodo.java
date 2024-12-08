package ex.usecase.todo;

import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;
import ex.usecase.error.TodoNotFound;

public class UpdateTodo implements UpdateTodoUsecase {
    private final TodoRepository repo;

    public UpdateTodo(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Todo execute(int id, Todo todo) throws Exception {
        if (!repo.getById(id).isPresent()) {
            throw new TodoNotFound(id);
        }
        TodoValidator.validate(todo);
        Todo output = repo.update(id,todo);
        return output;
    }
}