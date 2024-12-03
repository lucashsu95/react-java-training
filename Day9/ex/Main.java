package ex;

import ex.controller.TodoController;
import ex.usecase.ListTodoUseCase;
import ex.infrastructure.repository.InMemoryTodoRepository;
import ex.interfaces.presenter.TodoPresenter;

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
