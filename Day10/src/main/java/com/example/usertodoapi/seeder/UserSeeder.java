package com.example.usertodoapi.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.usertodoapi.domain.entity.User;
import com.example.usertodoapi.domain.repository.UserRepository;

@Component
public class UserSeeder {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void seedUsers() {
        if (userRepository.count() <= 0) {
            User admin = new User();
            admin.setEmail("admin@web.com");
            admin.setPasswordHash(passwordEncoder.encode("adminpass"));
            admin.setNickname("admin");
            admin.setType(User.UserType.ADMIN);
            userRepository.save(admin);

            for (int i = 1; i <= 5; i++) {
                User user = new User();
                user.setEmail("user" + i + "@web.com");
                user.setPasswordHash(passwordEncoder.encode("user" + i + "pass"));
                user.setNickname("user" + i);
                user.setType(User.UserType.USER);
                userRepository.save(user);
            }
        }
    }
}