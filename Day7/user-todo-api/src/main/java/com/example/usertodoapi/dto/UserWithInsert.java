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
    @NotNull(message = "不能為空")
    @Email(message = "格式不正確")
    @NotBlank(message = "不能為空")
    private String email;

    @NotBlank(message = "不能為空")
    @NotNull(message = "不能為空")
    private String nickname;

    @NotNull(message = "不能為空")
    @NotBlank(message = "不能為空")
    private String type;

    @NotNull(message = "不能為空")
    @NotBlank(message = "不能為空")
    private String password;
}