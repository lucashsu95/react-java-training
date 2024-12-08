package ex.interfaces.presenter.todo;

import ex.domain.entity.Todo;
import ex.interfaces.presenter.todo.model.TodoJsonOutput;

public class CreateTodoJson implements CreateTodoJsonPresenter {

    @Override
    public TodoJsonOutput Output(Todo output) {
        return new TodoJsonOutput(true, output, "");
    }

    @Override
    public TodoJsonOutput Error(Exception err) {
        return new TodoJsonOutput(false, null, err.getMessage());
    }
}
