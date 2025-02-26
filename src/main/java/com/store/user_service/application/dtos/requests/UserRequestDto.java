package com.store.user_service.application.dtos.requests;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class UserRequestDto {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must only contain letters and spaces")
    private String name;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Last name must only contain letters and spaces")
    private String lastName;

    @NotNull(message = "Document is mandatory")
    private Long document;

    @NotNull(message = "Cellphone is mandatory")
    private Long cellphone;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must have at least 8 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;

    @NotNull(message = "Birthdate is mandatory")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
}
