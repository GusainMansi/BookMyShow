package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Service.Implementation.UserServiceImpl;

import com.example.BookMyShow.dto.EntryDto.UserEntry;
import com.example.BookMyShow.dto.EntryDto.UserEntry;
import com.example.BookMyShow.dto.EntryDto.UserEntry;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserEntry userEntryDto){

        userService.addUser(userEntryDto);

        return new ResponseEntity("Added you successfully ", HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}