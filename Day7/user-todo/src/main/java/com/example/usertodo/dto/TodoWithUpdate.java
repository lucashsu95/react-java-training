package com.example.usertodo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TodoWithUpdate {
    String title;
    String content;
    Boolean completed;
}
