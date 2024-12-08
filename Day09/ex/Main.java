package ex;

import ex.controller.TodoController;
import ex.domain.entity.Todo;
import ex.domain.repository.TodoRepository;
import ex.infrastructure.repository.TodoRepositoryInMemory;
import ex.interfaces.presenter.todo.TodoJsonPresenter;
import ex.interfaces.presenter.todo.TodoXmlPresenter;
import ex.interfaces.presenter.todo.xml.*;
import ex.interfaces.presenter.todo.json.*;
import ex.usecase.TodoUsecase;
import ex.usecase.todo.*;

public class Main {
    public static void main(String[] args) {
        // repo
        TodoRepository repository = new TodoRepositoryInMemory();

        // usecase
        CreateTodoUsecase createTodoUsecase = new CreateTodo(repository);
        ListTodoUsecase listTodoUsecase = new ListTodo(repository);
        DeleteTodoUsecase deleteTodoUsecase = new DeleteTodo(repository);
        UpdateTodoUsecase updateTodoUsecase = new UpdateTodo(repository);

        // presenter json
        ListTodoJsonPresenter listTodoJsonPresenter = new ListTodoJsonPresenter();
        CreateTodoJsonPresenter createTodoJsonPresenter = new CreateTodoJsonPresenter();
        DeleteTodoJsonPresenter deleteTodoJsonPresenter = new DeleteTodoJsonPresenter();
        UpdateTodoJsonPresenter updateTodoJsonPresenter = new UpdateTodoJsonPresenter();
        
        // presenter for json
        ListTodoXmlPresenter listTodoXmlPresenter = new ListTodoXmlPresenter();
        CreateTodoXmlPresenter createTodoXmlPresenter = new CreateTodoXmlPresenter();
        DeleteTodoXmlPresenter deleteTodoXmlPresenter = new DeleteTodoXmlPresenter();
        UpdateTodoXmlPresenter updateTodoXmlPresenter = new UpdateTodoXmlPresenter();

        // Facade
        TodoUsecase todoUsecase = new TodoUsecase(
                listTodoUsecase,
                createTodoUsecase,
                deleteTodoUsecase,
                updateTodoUsecase);
        TodoJsonPresenter todoJsonPresenter = new TodoJsonPresenter(
                listTodoJsonPresenter,
                createTodoJsonPresenter,
                deleteTodoJsonPresenter,
                updateTodoJsonPresenter);
        TodoXmlPresenter todoXmlPresenter = new TodoXmlPresenter(
                listTodoXmlPresenter,
                createTodoXmlPresenter,
                deleteTodoXmlPresenter,
                updateTodoXmlPresenter);

        // controller
        TodoController todoController = new TodoController(todoUsecase, todoJsonPresenter);
        // TodoController todoController = new TodoController(todoUsecase, todoXmlPresenter);

        Todo todo = new Todo("Sample Todo", false);
        Todo todo2 = new Todo("", false);
        Todo todo3 = new Todo("Sample Todo2", false);

        todoController.createTodo(todo);
        todoController.createTodo(todo2);
        todoController.createTodo(todo3);

        todoController.listTodos();

        todoController.deleteTodo(1);
        todoController.deleteTodo(4);

        todoController.listTodos();
        todoController.updateTodo(2, new Todo("Updated Todo", true));
        todoController.listTodos();
    }
}
