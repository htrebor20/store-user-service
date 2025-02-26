package com.store.user_service.infrastructure.adapters;

import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.out.IUserPersistencePort;
import com.store.user_service.infrastructure.entities.UserEntity;
import com.store.user_service.infrastructure.mappers.IUserEntityMapper;
import com.store.user_service.infrastructure.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {
    private final IUserRepository  userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        UserEntity userEntity = userRepository.save(entity);

        User model = userEntityMapper.toModel(userEntity);
        return model;
    }
}
