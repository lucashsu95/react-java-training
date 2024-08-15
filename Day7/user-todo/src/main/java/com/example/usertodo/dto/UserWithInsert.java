package com.example.usertodo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserWithInsert {
    @NotNull()
    private String email;

    @NotNull()
    private String nickname;

    @NotNull()
    private String type;

    @NotNull()
    private String password;
}