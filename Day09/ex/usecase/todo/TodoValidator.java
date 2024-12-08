
package ex.usecase.todo;

import ex.domain.entity.Todo;

public class TodoValidator {
    public static void validate(Todo todo) throws IllegalArgumentException {
        if (todo == null) {
            throw new IllegalArgumentException("Todo cannot be null");
        }
        if (todo.getTitle() == null || todo.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (todo.getCompleted() != false && todo.getCompleted() != true) {
            throw new IllegalArgumentException("Completed status must be true or false");
        }
    }
}