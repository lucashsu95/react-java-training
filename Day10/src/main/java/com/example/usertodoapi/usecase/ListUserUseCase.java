
package com.example.usertodoapi.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usertodoapi.domain.entity.User;
import com.example.usertodoapi.domain.repository.UserRepository;

@Service
public class ListUserUseCase {
    private final UserRepository repository;
    
    @Autowired
    public ListUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute() {
        return repository.findAll();
    }
}