package com.example.usertodo.Repository;

import com.example.usertodo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email,Long id) ;
}
