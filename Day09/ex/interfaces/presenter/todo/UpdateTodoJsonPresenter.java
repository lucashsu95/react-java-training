package ex.interfaces.presenter.todo;

import ex.domain.entity.Todo;
import ex.interfaces.presenter.todo.model.TodoJsonOutput;

public interface UpdateTodoJsonPresenter {
    TodoJsonOutput Output(Todo output);
    TodoJsonOutput Error(Exception e);
}
