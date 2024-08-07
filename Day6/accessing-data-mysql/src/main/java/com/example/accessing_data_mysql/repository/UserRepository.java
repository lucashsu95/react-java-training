package com.example.accessing_data_mysql.repository;

import com.example.accessing_data_mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(User user);
}
