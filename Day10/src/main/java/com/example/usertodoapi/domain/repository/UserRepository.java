package com.example.usertodoapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.usertodoapi.domain.entity.User;

public interface UserRepository {
    List<User> getAll();

    Optional<User> getById(int id);

    void create(User user);

    void update(int id, User user);

    void delete(int id);
}