package com.example.usertodo.Repository;

import com.example.usertodo.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email,Long id) ;
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.access_token = :token")
    Optional<User> findByAccessToken(@Param("token") String token);
}
