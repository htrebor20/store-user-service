package com.store.user_service.domain.ports.out;

import com.store.user_service.domain.model.User;

public interface IUserPersistencePort {
    User saveUser (User user);
}
