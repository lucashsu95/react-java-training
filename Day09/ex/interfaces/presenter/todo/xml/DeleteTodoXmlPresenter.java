package ex.interfaces.presenter.todo.xml;

import ex.interfaces.presenter.todo.model.TodoXmlOutput;

public class DeleteTodoXmlPresenter {

    public TodoXmlOutput Output() {
        return new TodoXmlOutput(true, "");
    }

    public TodoXmlOutput Error(Exception err) {
        return new TodoXmlOutput(false, null, err.getMessage());
    }
}
