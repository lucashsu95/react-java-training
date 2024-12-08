package ex.usecase.todo;

import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;

public class CreateTodo implements CreateTodoUsecase {
    private final TodoRepository repo;

    public CreateTodo(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Todo execute(Todo todo) throws IllegalArgumentException {
        try {
            if (todo == null) {
                throw new IllegalArgumentException("Todo cannot be null");
            }
            if (todo.getTitle() == null || todo.getTitle().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }
            if (todo.getCompleted() != false && todo.getCompleted() != true) {
                throw new IllegalArgumentException("Completed status must be true or false");
            }
            Todo output = repo.create(todo);
            return output;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}