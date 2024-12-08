package ex;

import ex.controller.TodoController;
import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;
import ex.infrastructure.repository.TodoRepositoryInMemory;
import ex.interfaces.presenter.TodoJsonPresenter;
import ex.interfaces.presenter.todo.*;
import ex.usecase.TodoUsecase;
import ex.usecase.todo.*;

public class Main {
    public static void main(String[] args) {
        // repo
        TodoRepository repository = new TodoRepositoryInMemory();

        // usecase
        CreateTodoUsecase createTodoUsecase = new CreateTodo(repository);
        ListTodoUsecase listTodoUsecase = new ListTodo(repository);

        // presenter
        ListTodoJsonPresenter listTodoJsonPresenter = new ListTodoJson();
        CreateTodoJsonPresenter createTodoJsonPresenter = new CreateTodoJson();

        // Facade
        TodoUsecase todoUsecase = new TodoUsecase(createTodoUsecase, listTodoUsecase);
        TodoJsonPresenter todoJsonPresenter = new TodoJsonPresenter(listTodoJsonPresenter, createTodoJsonPresenter);

        // controller
        TodoController todoController = new TodoController(todoUsecase, todoJsonPresenter);
        

        Todo todo = new Todo("Sample Todo", false);
        Todo todo2 = new Todo("", false);
        Todo todo3 = new Todo("Sample Todo2", false);

        todoController.createTodo(todo);
        todoController.createTodo(todo2);
        todoController.createTodo(todo3);

        todoController.listTodos();
    }
}
