package com.example.usertodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories
@EnableJpaAuditing
public class UserTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTodoApplication.class, args);
    }

}
