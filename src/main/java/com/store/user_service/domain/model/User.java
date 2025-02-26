package com.store.user_service.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class User {
    private final String name;
    private final String lastName;
    private final Long document;
    private final Long cellphone;
    private final String email;
    private final String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate birthdate;

    public User(String name, String lastName, Long document, Long cellphone, String email, String password, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getDocument() {
        return document;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
