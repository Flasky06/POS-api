package com.pos_app.pos_app.services;

import com.pos_app.pos_app.domain.dto.UserRequestDto;
import com.pos_app.pos_app.domain.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserRequestDto userRequest);

    List<UserDto> listUsers();

    UserDto updateUser(UserRequestDto userRequestDto, UUID userId);

    UserDto getUserById(UUID userId);

    void deleteUser(UUID userId);
}
