package ex.usecase;

import ex.usecase.todo.CreateTodoUsecase;
import ex.usecase.todo.ListTodoOutput;
import ex.usecase.todo.ListTodoUsecase;

public class TodoUsecase {
    private final CreateTodoUsecase createTodo;
    private final ListTodoUsecase listTodo;

    public TodoUsecase(
            CreateTodoUsecase createTodo,
            ListTodoUsecase listTodo) {
        this.createTodo = createTodo;
        this.listTodo = listTodo;
    }

    public CreateTodoUsecase CreateTodo() {
        return createTodo;
    }

    public ListTodoOutput ListTodo() {
        return listTodo.execute();
    }
}