package com.example.usertodoapi.dto;

import com.example.usertodoapi.model.User;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserWithToken {
    private final Long id;
    private final String email;
    private final String nickname;
    private final String type;
    private final String access_token;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;

    public UserWithToken(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.access_token = user.getAccess_token();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.nickname = user.getNickname();
        this.type = String.valueOf(user.getType());
    }
}
