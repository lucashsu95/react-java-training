package com.example.usertodo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserWithUpdate {
    String email;
    String nickname;
    String type;
    String password;
}
