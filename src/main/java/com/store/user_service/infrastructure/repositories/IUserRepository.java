package com.store.user_service.infrastructure.repositories;

import com.store.user_service.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity , Long> {
}
