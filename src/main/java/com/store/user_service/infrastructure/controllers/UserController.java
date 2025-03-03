package com.store.user_service.infrastructure.controllers;

import com.store.user_service.application.dtos.requests.UserRequestDto;
import com.store.user_service.application.dtos.responses.UserResponseDto;
import com.store.user_service.application.mappers.IUserRequestMapper;
import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.in.IUserServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Operations related to user management")

public class UserController {
    private final IUserRequestMapper userRequestMapper;
    private final IUserServicePort userServicePort;

    @PostMapping("/")
    @Operation(
            summary = "Create a new user",
            description = "This endpoint allows you to create a user in the system."
    )
    @RequestBody(
            required = true,
            content = @Content(
                    schema = @Schema(
                            implementation = UserRequestDto.class,
                            description = "User data required for registration"
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User successfully created",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad request (invalid data)")
    })
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto request) {
        User user = userRequestMapper.toModel(request);
        User user1 = userServicePort.create(user);
        UserResponseDto response = userRequestMapper.toResponse(user1);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
