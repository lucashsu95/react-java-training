// package com.example.usertodoapi.infrastructure.repository;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Repository;

// import com.example.usertodoapi.domain.entity.User;
// import com.example.usertodoapi.domain.repository.UserRepository;

// @Repository
// public class InMemoryUserRepository implements UserRepository {
//     private final List<User> users = new ArrayList<>();

//     @Override
//     public List<User> getAll() {
//         return new ArrayList<>(users);
//     }

//     @Override
//     public Optional<User> getById(int id) {
//         return users.stream().filter(user -> user.getId() == id).findFirst();
//     }

//     @Override
//     public void create(User user) {
//         users.add(user);
//     }

//     @Override
//     public void update(int id, User user) {
//         getById(id).ifPresent(existingUser -> {
//             existingUser.setNickname(user.getNickname());
//             existingUser.setEmail(user.getEmail()); 
//         });
//     }

//     @Override
//     public void delete(int id) {
//         users.removeIf(user -> user.getId() == id);
//     }
// }
