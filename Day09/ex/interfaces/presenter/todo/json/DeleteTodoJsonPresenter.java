package ex.interfaces.presenter.todo.json;

import ex.interfaces.presenter.todo.model.TodoJsonOutput;

public class DeleteTodoJsonPresenter {

    public TodoJsonOutput Output() {
        return new TodoJsonOutput(true, "");
    }

    public TodoJsonOutput Error(Exception err) {
        return new TodoJsonOutput(false, null, err.getMessage());
    }
}
