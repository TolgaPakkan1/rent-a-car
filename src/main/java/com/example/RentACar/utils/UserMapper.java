package com.example.RentACar.utils;

import com.example.RentACar.dto.UserDto;
import com.example.RentACar.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userToUserDto(User user);

}
