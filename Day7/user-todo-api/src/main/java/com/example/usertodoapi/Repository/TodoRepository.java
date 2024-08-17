package com.example.usertodoapi.Repository;

import com.example.usertodoapi.model.Todo;
import com.example.usertodoapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByUser(User user);

}
