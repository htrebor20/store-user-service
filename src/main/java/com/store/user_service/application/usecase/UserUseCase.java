package com.store.user_service.application.usecase;

import com.store.user_service.application.constants.Constants;
import com.store.user_service.application.constants.ErrorMessages;
import com.store.user_service.domain.exception.BadRequestValidationException;
import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.in.IUserServicePort;
import com.store.user_service.domain.ports.out.IEmailSenderPort;
import com.store.user_service.domain.ports.out.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IEmailSenderPort emailSenderPort;
    
    @Override
    public User create(User user) {
        validateAge(user);
        User savedUser  = userPersistencePort.saveUser(user);
        emailSenderPort.sendEmail(user.getEmail(), "Bienvenido!", "Gracias por registrarte en nuestra plataforma.");
        return savedUser ;
    }

    private void validateAge(User user) {
        LocalDate currentDate = LocalDate.now();
        if (user.getBirthdate() == null) {
            throw new BadRequestValidationException(ErrorMessages.BIRTHDATE_MANDATORY_EXCEPTION_MESSAGE);
        }
        int age = Period.between(user.getBirthdate(), currentDate).getYears();
        if (age < Constants.MINIMUM_AGE) {
            throw new BadRequestValidationException(ErrorMessages.AGE_VALIDATIONS_EXCEPTION_MESSAGE);
        }
    }

}

