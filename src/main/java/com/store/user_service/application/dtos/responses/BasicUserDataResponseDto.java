package com.store.user_service.application.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class BasicUserDataResponseDto {
    private String name;
    private String lastName;
    private Long document;
    private Long cellphone;
    private String email;
}

