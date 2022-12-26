package com.example.BookMyShow.Controller;



import com.example.BookMyShow.Service.Implementation.TheatreServiceImpl;
import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;

import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theaterService;


    @PostMapping("add")
    public TheatreResponseDto addTheatre(@RequestBody() TheatreEntryDto theaterEntryDto){

        return theaterService.addTheatre(theaterEntryDto);

    }

}
