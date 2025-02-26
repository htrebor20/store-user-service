package com.store.user_service.application.usecase;

import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.in.IUserServicePort;
import com.store.user_service.domain.ports.out.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    @Override
    public User create(User user) {
        return userPersistencePort.saveUser(user);
    }
}
