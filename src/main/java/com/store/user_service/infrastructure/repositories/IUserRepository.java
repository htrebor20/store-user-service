package com.store.user_service.infrastructure.repositories;

import com.store.user_service.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity , Long> {
    Optional<UserEntity> findByEmail(String email);
}
