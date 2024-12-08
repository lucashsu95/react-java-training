package ex.interfaces.presenter;

import ex.interfaces.presenter.todo.CreateTodoJsonPresenter;
import ex.interfaces.presenter.todo.ListTodoJsonPresenter;

public class TodoJsonPresenter {
    private final CreateTodoJsonPresenter createTodo;
    private final ListTodoJsonPresenter listTodo;

    public TodoJsonPresenter(
            ListTodoJsonPresenter listTodo,
            CreateTodoJsonPresenter createTodo) {
        this.listTodo = listTodo;
        this.createTodo = createTodo;
    }

    public CreateTodoJsonPresenter CreateTodo() {
        return createTodo;
    }

    public ListTodoJsonPresenter ListTodo() {
        return listTodo;
    }
}
