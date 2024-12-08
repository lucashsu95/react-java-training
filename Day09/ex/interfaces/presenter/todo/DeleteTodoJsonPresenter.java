package ex.interfaces.presenter.todo;

import ex.interfaces.presenter.todo.model.TodoJsonOutput;

public interface DeleteTodoJsonPresenter {
    TodoJsonOutput Output();
    TodoJsonOutput Error(Exception e);
}
