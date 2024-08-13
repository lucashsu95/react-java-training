package com.example.usertodo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Getter
@RequiredArgsConstructor
public class UserWithInsert {
    @NotNull()
    private final String email;

    @NotNull()
    private final String nickname;

    @NotNull()
    private final String type;

    @NotNull()
    private final String password;
}