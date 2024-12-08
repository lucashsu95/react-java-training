package ex.usecase.todo;

import ex.domain.entity.Todo;

public interface UpdateTodoUsecase {
    Todo execute(int id, Todo todo) throws Exception;
}