package ex.interfaces.presenter;

import ex.interfaces.presenter.todo.CreateTodoJsonPresenter;
import ex.interfaces.presenter.todo.ListTodoJsonPresenter;
import ex.interfaces.presenter.todo.UpdateTodoJsonPresenter;
import ex.interfaces.presenter.todo.DeleteTodoJsonPresenter;

public class TodoJsonPresenter {
    private final CreateTodoJsonPresenter createTodo;
    private final ListTodoJsonPresenter listTodo;
    private final DeleteTodoJsonPresenter deleteTodo;
    private final UpdateTodoJsonPresenter updateTodo;

    public TodoJsonPresenter(
            ListTodoJsonPresenter listTodo,
            CreateTodoJsonPresenter createTodo,
            DeleteTodoJsonPresenter deleteTodo,
            UpdateTodoJsonPresenter updateTodo) {
        this.listTodo = listTodo;
        this.createTodo = createTodo;
        this.deleteTodo = deleteTodo;
        this.updateTodo = updateTodo;
    }

    public CreateTodoJsonPresenter CreateTodo() {
        return createTodo;
    }

    public ListTodoJsonPresenter ListTodo() {
        return listTodo;
    }

    public DeleteTodoJsonPresenter DeleteTodo() {
        return deleteTodo;
    }

    public UpdateTodoJsonPresenter UpdateTodo() {
        return updateTodo;
    }
}
