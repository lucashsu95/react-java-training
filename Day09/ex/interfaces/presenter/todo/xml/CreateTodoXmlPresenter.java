package ex.interfaces.presenter.todo.xml;

import ex.domain.entity.Todo;
import ex.interfaces.presenter.todo.model.TodoXmlOutput;

public class CreateTodoXmlPresenter {

    public TodoXmlOutput Output(Todo output) {
        return new TodoXmlOutput(true, output, "");
    }

    public TodoXmlOutput Error(Exception err) {
        return new TodoXmlOutput(false, null, err.getMessage());
    }
}
