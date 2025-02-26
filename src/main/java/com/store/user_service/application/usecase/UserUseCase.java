package com.store.user_service.application.usecase;

import com.store.user_service.domain.constants.Constants;
import com.store.user_service.domain.exception.BadRequestValidationException;
import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.in.IUserServicePort;
import com.store.user_service.domain.ports.out.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    @Override
    public User create(User user) {
        validateAge(user);

        return userPersistencePort.saveUser(user);
    }

    private void validateAge(User user) {
        LocalDate currentDate = LocalDate.now();
        if (user.getBirthdate() == null) {
            throw new BadRequestValidationException(Constants.BIRTHDATE_MANDATORY_EXCEPTION_MESSAGE);
        }
        int age = Period.between(user.getBirthdate(), currentDate).getYears();
        if (age < 18) {
            throw new BadRequestValidationException(Constants.AGE_VALIDATIONS_EXCEPTION_MESSAGE);
        }
    }

}

