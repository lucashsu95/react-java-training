package com.example.usertodoapi.seeder;

import com.example.usertodoapi.Repository.UserRepository;
import com.example.usertodoapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void seedUsers() {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setEmail("admin@example.com");
            admin.setPasswordHash(passwordEncoder.encode("password"));
            admin.setNickname("Admin");
            admin.setType(User.UserType.ADMIN);
            userRepository.save(admin);

            for (int i = 1; i <= 10; i++) {
                User user = new User();
                user.setEmail("user" + i + "@example.com");
                user.setPasswordHash(passwordEncoder.encode("user" + i + "pass"));
                user.setNickname("User" + i);
                user.setType(User.UserType.USER);
                userRepository.save(user);
            }
        }
    }
}