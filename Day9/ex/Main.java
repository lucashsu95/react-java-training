package com.example;

import com.example.controller.TodoController;
import com.example.domain.usecase.ListTodoUseCase;
import com.example.infrastructure.repository.InMemoryTodoRepository;
import com.example.presenter.TodoPresenter;

public class Main {
    public static void main(String[] args) {
        InMemoryTodoRepository repository = new InMemoryTodoRepository();
        ListTodoUseCase listTodoUseCase = new ListTodoUseCase(repository);
        TodoPresenter todoPresenter = new TodoPresenter();

        TodoController controller = new TodoController(listTodoUseCase, todoPresenter);

        // Example of listing todos
        System.out.println(controller.listTodos());
    }
}
