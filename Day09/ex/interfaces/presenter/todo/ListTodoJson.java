package ex.interfaces.presenter.todo;

import ex.interfaces.presenter.todo.model.ListTodoJsonOutput;
import ex.usecase.todo.*;

public class ListTodoJson implements ListTodoJsonPresenter {

    @Override
    public ListTodoJsonOutput Output(ListTodoOutput output) {
        return new ListTodoJsonOutput(true, output, "");
    }

    @Override
    public ListTodoJsonOutput Error(Exception err) {
        return new ListTodoJsonOutput(false, null, err.getMessage());
    }
}
