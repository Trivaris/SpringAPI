package org.trivaris.springapi.application.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.trivaris.springapi.domain.user.User;
import org.trivaris.springapi.presentation.user.dto.UserResponseDto;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserResponseDto toUserResponseDto(User user);
}
