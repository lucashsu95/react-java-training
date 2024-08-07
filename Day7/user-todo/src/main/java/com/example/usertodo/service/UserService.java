package com.example.usertodo.service;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> index() {
        return userRepository.findAll();
    }

    public User insert(User user) {
        userRepository.save(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> update(Long id, User request) {
        Optional<User> isExistUser = findById(id);
        if(isExistUser.isEmpty()) {
            return Optional.empty();
        }
        User user = isExistUser.get();

        String nickname = request.getNickname();
        user.setNickname(nickname);

        userRepository.save(user);
        return Optional.of(user);
    }

    public Boolean destroy(Long id) {
        Optional<User> isExistUser = findById(id);
        if(isExistUser.isEmpty()) {
            return false;
        }
        User user = isExistUser.get();
        userRepository.delete(user);
        return true;
    }
}
