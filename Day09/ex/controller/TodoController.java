package ex.controller;

import ex.domain.entity.Todo;
import ex.interfaces.presenter.todo.TodoJsonPresenter;
import ex.interfaces.presenter.todo.TodoXmlPresenter;
import ex.usecase.TodoUsecase;
import ex.usecase.todo.dto.ListTodoOutput;

public class TodoController {
    private final TodoUsecase usecase;
    private final TodoJsonPresenter presenter;
    // private final TodoXmlPresenter presenter;

    public TodoController(TodoUsecase todoUsecase, TodoJsonPresenter todoPresenter) {
        this.usecase = todoUsecase;
        this.presenter = todoPresenter;
    }

    public void listTodos() {
        try {
            ListTodoOutput todos = usecase.ListTodo().execute();
            System.out.println(presenter.ListTodo().Output(todos));
        } catch (Exception e) {
            System.out.println(presenter.ListTodo().Error(e));
        }
    }

    public void createTodo(Todo todo) {
        try {
            Todo newTodo = usecase.CreateTodo().execute(todo);
            System.out.println(presenter.CreateTodo().Output(newTodo));
        } catch (Exception e) {
            System.out.println(presenter.CreateTodo().Error(e));
        }
    }

    public void deleteTodo(int id) {
        try {
            usecase.DeleteTodo().execute(id);
            System.out.println(presenter.DeleteTodo().Output());
        } catch (Exception e) {
            System.out.println(presenter.DeleteTodo().Error(e));
        }
    }

    public void updateTodo(int id, Todo todo) {
        try {
            Todo newTodo = usecase.UpdateTodo().execute(id, todo);
            System.out.println(presenter.UpdateTodo().Output(newTodo));
        } catch (Exception e) {
            System.out.println(presenter.UpdateTodo().Error(e));
        }
    }
}