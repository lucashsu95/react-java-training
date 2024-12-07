package ex.controller;

import ex.domain.entity.Todo;
import ex.usecase.ListTodoUseCase;
import ex.interfaces.presenter.TodoPresenter;

import java.util.List;

public class TodoController {
    private final ListTodoUseCase listTodoUseCase;
    private final TodoPresenter todoPresenter;

    public TodoController(ListTodoUseCase listTodoUseCase, TodoPresenter todoPresenter) {
        this.listTodoUseCase = listTodoUseCase;
        this.todoPresenter = todoPresenter;
    }

    public TodoPresenter.ListTodoResponse listTodos() {
        try {
            List<Todo> todos = listTodoUseCase.execute();
            return todoPresenter.success(todos);
        } catch (Exception e) {
            return todoPresenter.error(e.getMessage());
        }
    }
}
