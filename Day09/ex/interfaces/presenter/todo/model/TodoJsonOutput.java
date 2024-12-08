package ex.interfaces.presenter.todo.model;

import ex.domain.entity.Todo;

public class TodoJsonOutput {
    private final boolean success;
    private final Todo data;
    private final String message;

    public TodoJsonOutput(boolean success, Todo output, String message) {
        this.success = success;
        this.data = output;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ListTodoResponse{\n" +
                "  success=" + success + ",\n" +
                "  data=" + data + ",\n" +
                "  message='" + message + "'\n" +
                '}';
    }
}
