package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.dto.TheatreDto;

public interface TheatreService {
    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);
    TheatreResponseDto getTheatre(int id);
}
