package com.store.user_service.application.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class UserResponseDto {
    private String name;
    private String lastName;
    private Long document;
    private Long cellphone;
    private String email;
    private String password;
}
