package com.example.usertodoapi;

import org.springframework.boot.SpringApplication;

public class TestusertodoapiApplication {

    public static void main(String[] args) {
        SpringApplication.from(UserTodoApiApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
