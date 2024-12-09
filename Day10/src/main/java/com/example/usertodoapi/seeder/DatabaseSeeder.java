package com.example.usertodoapi.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserSeeder userSeeder;

    @Autowired
    public DatabaseSeeder(UserSeeder userSeeder) {
        this.userSeeder = userSeeder;
    }

    @Override
    public void run(String... args) throws Exception {
        userSeeder.seedUsers();
    }
}