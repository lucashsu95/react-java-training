package com.example.usertodoapi.interfaces.presenter;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.usertodoapi.domain.entity.User;

@Component
public class UserPresenter {
    public static class ListUserResponse {
        private final boolean success;
        private final List<User> data;
        private final String message;

        public ListUserResponse(boolean success, List<User> data, String message) {
            this.success = success;
            this.data = data;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public List<User> getData() {
            return data;
        }

        public String getMessage() {
            return message;
        }
    }

    public ListUserResponse success(List<User> todos) {
        return new ListUserResponse(true, todos, "");
    }

    public ListUserResponse error(String message) {
        return new ListUserResponse(false, null, message);
    }
}
