package com.example.BookMyShow.dto.EntryDto;

import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class ShowEntryDto {
    @NotNull
    LocalDate showDate;
    @NotNull
    LocalTime showTime;
    @NotNull
    MovieResponseDto movieResponseDto;
    @NotNull
    TheatreResponseDto theatreResponseDto;

}
