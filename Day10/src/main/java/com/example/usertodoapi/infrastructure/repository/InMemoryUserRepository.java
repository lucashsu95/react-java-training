package com.example.usertodoapi.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.usertodoapi.domain.entity.User;
import com.example.usertodoapi.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final UserJpaRepository db;

    @Autowired
    public InMemoryUserRepository(UserJpaRepository db) {
        this.db = db;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(db.findAll());
    }

    @Override
    public Optional<User> getById(int id) {
        return db.findById(id);
    }

    @Override
    public void create(User user) {
        db.save(user);
    }

    @Override
    public void update(int id, User user) {
        // getById(id).ifPresent(existingUser -> {
        // existingUser.setNickname(user.getNickname());
        // existingUser.setEmail(user.getEmail());
        // });
        db.save(user);
    }

    @Override
    public void delete(int id) {
        db.deleteById(id);
        // users.removeIf(user -> user.getId() == id);
    }
}
