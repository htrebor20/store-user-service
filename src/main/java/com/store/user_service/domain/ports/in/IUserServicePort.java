package com.store.user_service.domain.ports.in;

import com.store.user_service.domain.model.User;

public interface IUserServicePort {
    User  create (User user);
    User findByEmail (String email);
}
