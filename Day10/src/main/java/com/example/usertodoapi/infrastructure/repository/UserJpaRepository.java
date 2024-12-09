package com.example.usertodoapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usertodoapi.domain.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> { }
