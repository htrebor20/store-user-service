package com.store.user_service.infrastructure.mappers;

import com.store.user_service.domain.model.User;
import com.store.user_service.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    User  toModel(UserEntity userEntity);

    UserEntity  toEntity(User user);
}
