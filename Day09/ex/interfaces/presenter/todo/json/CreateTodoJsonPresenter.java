package ex.interfaces.presenter.todo.json;

import ex.domain.entity.Todo;
import ex.interfaces.presenter.todo.model.TodoJsonOutput;

public class CreateTodoJsonPresenter {

    public TodoJsonOutput Output(Todo output) {
        return new TodoJsonOutput(true, output, "");
    }

    public TodoJsonOutput Error(Exception err) {
        return new TodoJsonOutput(false, null, err.getMessage());
    }
}
