package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.UserEntry;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;

public interface UserService {
    //add

    public void addUser(UserEntry userEntry);

    //get
     UserResponseDto getUser(int id);
}
