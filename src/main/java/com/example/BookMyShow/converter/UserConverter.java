package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.dto.EntryDto.UserEntry;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import com.example.BookMyShow.dto.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static UserEntity dtoToEntity(UserEntry userDto){
return UserEntity.builder().name(userDto.getName()).mobile(userDto.getMobileNo()).build();
    }


public static UserResponseDto convertEntityToDto(UserEntity user){
        return UserResponseDto.builder().id(user.getId()).name(user.getName()).mobileNo(user.getMobile())
                .build();}
}
