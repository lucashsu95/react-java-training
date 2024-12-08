package ex.controller;

import ex.domain.entity.Todo;
import ex.interfaces.presenter.TodoJsonPresenter;
import ex.usecase.TodoUsecase;
import ex.usecase.todo.ListTodoOutput;

public class TodoController {
    private final TodoUsecase usecase;
    private final TodoJsonPresenter presenter;

    public TodoController(TodoUsecase todoUsecase, TodoJsonPresenter todoPresenter) {
        this.usecase = todoUsecase;
        this.presenter = todoPresenter;
    }

    public void listTodos() {
        try {
            ListTodoOutput todos = usecase.ListTodo();
            System.out.println(presenter.ListTodo().Output(todos));
        } catch (Exception e) {
            System.out.println(presenter.ListTodo().Error(e));
        }
    }

    public void createTodo(Todo todo) {
        try {
            if (todo == null) {
                throw new IllegalArgumentException("Todo cannot be null");
            }
            if (todo.getTitle() == null || todo.getTitle().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }
            usecase.CreateTodo().execute(todo);
            System.out.println(presenter.CreateTodo().Output(todo));
        } catch (Exception e) {
            System.out.println(presenter.CreateTodo().Error(e));
        }
    }
}