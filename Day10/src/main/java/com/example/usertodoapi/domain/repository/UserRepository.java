package com.example.usertodoapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.usertodoapi.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> getAll();

    // Optional<User> getById(int id);

    // void create(User user);

    // void update(int id, User user);

    // void delete(int id);
}