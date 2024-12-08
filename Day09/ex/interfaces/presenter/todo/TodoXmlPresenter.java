package ex.interfaces.presenter.todo;

import ex.interfaces.presenter.todo.xml.CreateTodoXmlPresenter;
import ex.interfaces.presenter.todo.xml.ListTodoXmlPresenter;
import ex.interfaces.presenter.todo.xml.UpdateTodoXmlPresenter;
import ex.interfaces.presenter.todo.xml.DeleteTodoXmlPresenter;

public class TodoXmlPresenter {
    private final CreateTodoXmlPresenter createTodo;
    private final ListTodoXmlPresenter listTodo;
    private final DeleteTodoXmlPresenter deleteTodo;
    private final UpdateTodoXmlPresenter updateTodo;

    public TodoXmlPresenter(
            ListTodoXmlPresenter listTodo,
            CreateTodoXmlPresenter createTodo,
            DeleteTodoXmlPresenter deleteTodo,
            UpdateTodoXmlPresenter updateTodo) {
        this.listTodo = listTodo;
        this.createTodo = createTodo;
        this.deleteTodo = deleteTodo;
        this.updateTodo = updateTodo;
    }

    public CreateTodoXmlPresenter CreateTodo() {
        return createTodo;
    }

    public ListTodoXmlPresenter ListTodo() {
        return listTodo;
    }

    public DeleteTodoXmlPresenter DeleteTodo() {
        return deleteTodo;
    }

    public UpdateTodoXmlPresenter UpdateTodo() {
        return updateTodo;
    }
}
