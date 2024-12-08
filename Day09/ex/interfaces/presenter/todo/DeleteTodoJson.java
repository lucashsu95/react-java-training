package ex.interfaces.presenter.todo;

import ex.interfaces.presenter.todo.model.TodoJsonOutput;

public class DeleteTodoJson implements DeleteTodoJsonPresenter {

    @Override
    public TodoJsonOutput Output() {
        return new TodoJsonOutput(true, "");
    }

    @Override
    public TodoJsonOutput Error(Exception err) {
        return new TodoJsonOutput(false, null, err.getMessage());
    }
}
