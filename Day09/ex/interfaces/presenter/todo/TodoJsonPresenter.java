package ex.interfaces.presenter.todo;

import ex.interfaces.presenter.todo.json.CreateTodoJsonPresenter;
import ex.interfaces.presenter.todo.json.ListTodoJsonPresenter;
import ex.interfaces.presenter.todo.json.UpdateTodoJsonPresenter;
import ex.interfaces.presenter.todo.json.DeleteTodoJsonPresenter;

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
