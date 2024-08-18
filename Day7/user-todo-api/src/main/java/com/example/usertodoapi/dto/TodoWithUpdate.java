package com.example.usertodoapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TodoWithUpdate {
    String title;
    String content;
    Boolean completed;
}
