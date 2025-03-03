package com.store.user_service.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String lastName;
    private Long document;
    private Long cellphone;
    private String email;
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

}