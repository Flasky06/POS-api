package com.pos_app.pos_app.mapper;

import com.pos_app.pos_app.domain.dto.UserDto;
import com.pos_app.pos_app.domain.dto.UserRequestDto;
import com.pos_app.pos_app.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDTO(User user);
    User toEntity(UserRequestDto requestDto);

}
