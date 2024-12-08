package ex.usecase.todo;

import ex.domain.repository.TodoRepository;
import ex.usecase.error.TodoNotFound;

public class DeleteTodo implements DeleteTodoUsecase {
    private final TodoRepository repo;

    public DeleteTodo(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(int id) throws TodoNotFound {
        if (!repo.getById(id).isPresent()) {
            throw new TodoNotFound(id);
        }
        repo.delete(id);
    }
}