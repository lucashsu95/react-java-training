package ex.interfaces.presenter.todo.model;

import ex.usecase.todo.dto.ListTodoOutput;

public class ListTodoJsonOutput {
    private final boolean success;
    private final ListTodoOutput data;
    private final String message;

    public ListTodoJsonOutput(boolean success, ListTodoOutput data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public ListTodoOutput getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ListTodoJsonOutput{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}