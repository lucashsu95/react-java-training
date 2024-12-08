package ex.usecase.error;

public class TodoNotFound extends Exception {
    public TodoNotFound(int id) {
        super("Todo with id " + id + " not found");
    }

    public TodoNotFound(String message) {
        super(message);
    }

    public TodoNotFound(Throwable cause) {
        super(cause);
    }

    public TodoNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public static boolean isTodoNotFoundError(Exception e) {
        return e instanceof TodoNotFound;
    }
}