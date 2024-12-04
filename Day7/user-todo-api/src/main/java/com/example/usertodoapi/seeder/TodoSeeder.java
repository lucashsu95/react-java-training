package com.example.usertodoapi.seeder;

import com.example.usertodoapi.Repository.TodoRepository;
import com.example.usertodoapi.model.Todo;
import com.example.usertodoapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoSeeder {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public void seedTodos() {
        if (todoRepository.count() == 0) {
            userRepository.findAll().forEach(user -> {
                for (int i = 1; i <= 5; i++) {
                    Todo todo = new Todo();
                    todo.setTitle("todo" + i);
                    todo.setContent("this is todo " + i + " content");
                    todo.setCompleted(false);
                    todo.setUser(user);
                    todoRepository.save(todo);
                }
            });
        }
    }
}