package com.store.user_service.application.constants;

public class ErrorMessages {
    private ErrorMessages() {

    }
    public static final String BIRTHDATE_MANDATORY_EXCEPTION_MESSAGE = "The user birthdate is mandatory.";
    public static final String AGE_VALIDATIONS_EXCEPTION_MESSAGE = "The user must be an adult.";
    public static final String EMAIL_DUPLICATE = "The email is already registered.";
    public static final String EMAIL_NOT_FOUND = "User with email %s not found.";

    public static String getEmailNotFoundMessage(String email) {
        return String.format(EMAIL_NOT_FOUND, email);
    }
}
