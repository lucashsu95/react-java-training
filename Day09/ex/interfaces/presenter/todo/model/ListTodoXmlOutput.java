
package ex.interfaces.presenter.todo.model;

import ex.usecase.todo.dto.ListTodoOutput;

public class ListTodoXmlOutput {
    private final boolean success;
    private final ListTodoOutput data;
    private final String message;

    public ListTodoXmlOutput(boolean success, ListTodoOutput data, String message) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("<ListTodoJsonOutput>\n");
        sb.append("  <success>").append(success).append("</success>\n");
        if (data != null) {
            sb.append("  <data>").append(data).append("</data>\n");
        }
        sb.append("  <message>").append(message).append("</message>\n");
        sb.append("</ListTodoJsonOutput>");
        return sb.toString();
    }
}