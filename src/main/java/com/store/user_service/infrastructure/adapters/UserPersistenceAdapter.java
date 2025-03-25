package com.store.user_service.infrastructure.adapters;

import com.store.user_service.application.constants.ErrorMessages;
import com.store.user_service.domain.exception.BadRequestValidationException;
import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.out.IUserPersistencePort;
import com.store.user_service.infrastructure.entities.UserEntity;
import com.store.user_service.infrastructure.mappers.IUserEntityMapper;
import com.store.user_service.infrastructure.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        Optional<UserEntity> byEmail = userRepository.findByEmail(user.getEmail());

        if (byEmail.isPresent()) {
            throw new BadRequestValidationException(ErrorMessages.EMAIL_DUPLICATE
            );
        }
        UserEntity entity = userEntityMapper.toEntity(user);
        UserEntity userEntity = userRepository.save(entity);

        return userEntityMapper.toModel(userEntity);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userEntityMapper::toModel)
                .orElseThrow(() -> new BadRequestValidationException(ErrorMessages.getEmailNotFoundMessage(email)));
    }
}
