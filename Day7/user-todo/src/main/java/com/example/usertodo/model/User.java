package com.example.usertodo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String nickname;

    @Column()
    private String email;

    @Column(name = "password_hash")
    private String password;


    @Enumerated(EnumType.STRING)
    @Column()
    private UserType type;

    @Column()
    private String access_token;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public enum UserType {
        USER,
        ADMIN
    }
}
