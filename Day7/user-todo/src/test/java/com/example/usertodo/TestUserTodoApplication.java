package com.example.usertodo;

import org.springframework.boot.SpringApplication;

public class TestUserTodoApplication {

    public static void main(String[] args) {
        SpringApplication.from(UserTodoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
