package com.example.accessing_data_mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessing_data_mysql.model.User;
import com.example.accessing_data_mysql.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createUser(User user) {
        // validateUser(user);
        // if (userExists(user)) {
        //     throw new UserExistsException();
        // }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // private boolean userExists(User user) {
    //     return userRepository.findByEmail(user).isPresent();
    // }

    // public User getUser(Long id) {
    //     return userRepository.findById(id).orElseThrow(() -> new UserException("USER_NOT_FOUND"));
    // }

    // public User updateUser(Long id, User userDetails) {
    //     User user = userRepository.findById(id).orElseThrow(() -> new UserException("USER_NOT_FOUND"));
    //     user.setEmail(userDetails.getEmail());
    //     user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
    //     user.setRole(userDetails.getRole());
    //     user.setNickname(userDetails.getNickname());
    //     return userRepository.save(user);
    // }

    // public void deleteUser(Long id) {
    //     User user = userRepository.findById(id).orElseThrow(() -> new UserException("USER_NOT_FOUND"));
    //     userRepository.delete(user);
    // }

    // private void validateUser(User user) {
    //     if (user.getEmail() == null || user.getEmail().isEmpty()) {
    //         throw new UserException("MISSING_FIELD");
    //     }

    //     if (user.getPassword() == null || user.getPassword().isEmpty()) {
    //         throw new UserException("MISSING_FIELD");
    //     }

    //     if (user.getRole() == null) {
    //         throw new UserException("MISSING_FIELD");
    //     }

    //     if (user.getNickname() == null || user.getNickname().isEmpty()) {
    //         throw new UserException("MISSING_FIELD");
    //     }

    //     // Additional format checks can be added here
    //     if (!user.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
    //         throw new UserException("WRONG_DATA_TYPE");
    //     }
    // }
}
