package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.UserService;
import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.EntryDto.UserEntry;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import com.example.BookMyShow.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void  addUser(UserEntry userEntryDto){
        UserEntity userEntity= UserConverter.dtoToEntity(userEntryDto);
        userRepository.save(userEntity);
    }
    @Override
    public UserResponseDto getUser(int id){
        UserEntity user=new UserEntity();
      UserEntity userEntity=  userRepository.findById(id).get();
       UserResponseDto userResponseDto= UserConverter.convertEntityToDto(userEntity);
       return userResponseDto;
    }
}
