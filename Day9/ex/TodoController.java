package com.example.controller;

import com.example.domain.entity.Todo;
import com.example.domain.usecase.ListTodoUseCase;
import com.example.presenter.TodoPresenter;

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
