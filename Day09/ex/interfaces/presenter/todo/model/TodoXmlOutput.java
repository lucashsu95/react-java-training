
package ex.interfaces.presenter.todo.model;

import ex.domain.entity.Todo;

public class TodoXmlOutput {
    private final boolean success;
    private final Todo data;
    private final String message;

    public TodoXmlOutput(boolean success, Todo output, String message) {
        this.success = success;
        this.data = output;
        this.message = message;
    }

    public TodoXmlOutput(boolean success, String message) {
        this.success = success;
        this.data = null;
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Response>\n");
        sb.append("  <success>").append(success).append("</success>\n");
        if (data != null) {
            sb.append("  <data>").append(data).append("</data>\n");
        }
        sb.append("  <message>").append(message).append("</message>\n");
        sb.append("</Response>");
        return sb.toString();
    }
}