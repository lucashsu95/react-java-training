package com.example.usertodoapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TodoWithUpdate {
    @NotBlank(message = "不能為空")
    String title;

    @NotBlank(message = "不能為空")
    String content;

    @NotBlank(message = "不能為空")
    Boolean completed;
}
