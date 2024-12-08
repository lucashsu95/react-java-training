package ex.interfaces.presenter.todo.json;

import ex.interfaces.presenter.todo.model.ListTodoJsonOutput;
import ex.usecase.todo.dto.ListTodoOutput;

public class ListTodoJsonPresenter {

    public ListTodoJsonOutput Output(ListTodoOutput output) {
        return new ListTodoJsonOutput(true, output, "");
    }

    public ListTodoJsonOutput Error(Exception err) {
        return new ListTodoJsonOutput(false, null, err.getMessage());
    }
}
