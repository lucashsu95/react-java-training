package com.example.usertodoapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserLoginInputs {
    @NotNull(message = "不能為空")
    @Email(message = "格式不正確")
    @NotBlank(message = "不能為空")
    String email;

    @NotNull(message = "不能為空")
    @NotBlank(message = "不能為空")
    String password;
}
