package com.example.presenter;

import com.example.domain.entity.Todo;

import java.util.List;

public class TodoPresenter {
    public static class ListTodoResponse {
        private final boolean success;
        private final List<Todo> data;
        private final String message;

        public ListTodoResponse(boolean success, List<Todo> data, String message) {
            this.success = success;
            this.data = data;
            this.message = message;
        }

        // Getters
        public boolean isSuccess() {
            return success;
        }

        public List<Todo> getData() {
            return data;
        }

        public String getMessage() {
            return message;
        }
    }

    public ListTodoResponse success(List<Todo> todos) {
        return new ListTodoResponse(true, todos, "");
    }

    public ListTodoResponse error(String message) {
        return new ListTodoResponse(false, null, message);
    }
}
