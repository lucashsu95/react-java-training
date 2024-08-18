package com.example.usertodoapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserWithInsert {
    @NotNull()
    @Email(message = "格式不正確")
    @NotBlank(message = "不得是空值")
    private String email;

    @NotBlank(message = "不得是空值")
    @NotNull()
    private String nickname;

    @NotNull()
    @NotBlank(message = "不得是空值")
    private String type;

    @NotNull()
    @NotBlank(message = "不得是空值")
    private String password;
}