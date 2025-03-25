package com.store.user_service.infrastructure.controllers;

import com.store.user_service.application.dtos.requests.UserRequestDto;
import com.store.user_service.application.dtos.responses.BasicUserDataResponseDto;
import com.store.user_service.application.dtos.responses.UserResponseDto;
import com.store.user_service.application.mappers.IUserRequestMapper;
import com.store.user_service.domain.model.User;
import com.store.user_service.domain.ports.in.IUserServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserRequestMapper userRequestMapper;
    private final IUserServicePort userServicePort;

    @PostMapping("/")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto request) {
        User user = userRequestMapper.toModel(request);
        User user1 = userServicePort.create(user);
        UserResponseDto response = userRequestMapper.toResponse(user1);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/email")
    public ResponseEntity<BasicUserDataResponseDto> createUser(@RequestParam String email) {

        User user = userServicePort.findByEmail(email);
        BasicUserDataResponseDto responseBasicData = userRequestMapper.toResponseBasicData(user);
        return new ResponseEntity<>(responseBasicData, HttpStatus.OK);
    }
}
