package com.store.user_service.application.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor

public class UserRequestDto {
    private String name;
    private String lastName;
    private Long document;
    private Long cellphone;
    private String email;
    private String password;
    private LocalDate birthdate;
}
