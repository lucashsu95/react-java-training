package ex.usecase;

import ex.usecase.todo.CreateTodoUsecase;
import ex.usecase.todo.DeleteTodoUsecase;
import ex.usecase.todo.ListTodoUsecase;
import ex.usecase.todo.UpdateTodoUsecase;

public class TodoUsecase {
    private final CreateTodoUsecase createTodo;
    private final ListTodoUsecase listTodo;
    private final DeleteTodoUsecase deleteTodo;
    private final UpdateTodoUsecase updateTodo;

    public TodoUsecase(
            ListTodoUsecase listTodo,
            CreateTodoUsecase createTodo,
            DeleteTodoUsecase deleteTodo,
            UpdateTodoUsecase updateTodo) {
        this.createTodo = createTodo;
        this.listTodo = listTodo;
        this.deleteTodo = deleteTodo;
        this.updateTodo = updateTodo;
    }

    public CreateTodoUsecase CreateTodo() {
        return createTodo;
    }

    public ListTodoUsecase ListTodo() {
        return listTodo;
    }

    public DeleteTodoUsecase DeleteTodo() {
        return deleteTodo;
    }

    public UpdateTodoUsecase UpdateTodo() {
        return updateTodo;
    }
}