package com.store.user_service.application.mappers;

import com.store.user_service.application.dtos.requests.UserRequestDto;
import com.store.user_service.application.dtos.responses.BasicUserDataResponseDto;
import com.store.user_service.application.dtos.responses.UserResponseDto;
import com.store.user_service.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    User toModel(UserRequestDto userRequestDto);

    UserResponseDto toResponse(User user);
    BasicUserDataResponseDto toResponseBasicData(User user);

}
