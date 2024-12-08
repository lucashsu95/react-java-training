package ex.usecase.todo;

import java.util.ArrayList;
import java.util.List;

import ex.domain.entity.Todo;

public class ListTodoOutput {
    private List<Todo> todos;

    public ListTodoOutput() {
        this.todos = new ArrayList<>();
    }

    public ListTodoOutput(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void add(Todo todo) {
        this.todos.add(todo);
    }

    public String toString() {
        return "ListTodoOutput{" +
                "todos=" + todos +
                '}';
    }
}