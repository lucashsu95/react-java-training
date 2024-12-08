package ex.interfaces.presenter.todo.xml;

import ex.interfaces.presenter.todo.model.ListTodoXmlOutput;
import ex.usecase.todo.dto.ListTodoOutput;

public class ListTodoXmlPresenter {

    public ListTodoXmlOutput Output(ListTodoOutput output) {
        return new ListTodoXmlOutput(true, output, "");
    }

    public ListTodoXmlOutput Error(Exception err) {
        return new ListTodoXmlOutput(false, null, err.getMessage());
    }
}
