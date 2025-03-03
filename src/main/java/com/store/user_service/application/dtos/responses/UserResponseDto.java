package com.store.user_service.application.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {
    private String name;
    private String lastName;
    private Long document;
    private Long cellphone;
    private String email;
    private String password;
}
