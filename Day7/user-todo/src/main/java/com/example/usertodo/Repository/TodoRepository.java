package com.example.usertodo.Repository;

import com.example.usertodo.model.Todo;
import com.example.usertodo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByUser(User user);

}
