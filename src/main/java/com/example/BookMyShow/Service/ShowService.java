package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.dto.ShowDto;

public interface ShowService {
     ShowResponseDto addShow(ShowEntryDto showEntryDto);
     ShowResponseDto getShow(int id,ShowEntryDto showEntryDto);


}
