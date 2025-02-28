package com.store.user_service.infrastructure.configuration;

import com.store.user_service.application.usecase.UserUseCase;
import com.store.user_service.domain.ports.in.IUserServicePort;
import com.store.user_service.domain.ports.out.IUserPersistencePort;
import com.store.user_service.infrastructure.adapters.UserPersistenceAdapter;
import com.store.user_service.infrastructure.mappers.IUserEntityMapper;
import com.store.user_service.infrastructure.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserEntityMapper  userEntityMapper;
    private final IUserRepository  userRepository;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper) ;
    }

    @Bean
    public IUserServicePort restaurantServicePort() {
        return new UserUseCase(userPersistencePort()) ;
    }
}
