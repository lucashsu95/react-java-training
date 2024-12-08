package ex.usecase.todo;

import ex.domain.entity.Todo;

public interface CreateTodoUsecase {
    Todo execute(Todo todo) throws Exception;
}