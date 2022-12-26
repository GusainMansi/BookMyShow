package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.dto.TheatreDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {
public static TheatreEntity dtoToEntity(TheatreEntryDto theatreDto){
    return TheatreEntity.builder().city(theatreDto.getCity()).name(theatreDto.getName()).address(theatreDto.getAddress()).build();
}
public static TheatreResponseDto entityToDto(TheatreEntity theatreEntity){
    return TheatreResponseDto.builder().city(theatreEntity.getCity()).name(theatreEntity.getName()).address(theatreEntity.getAddress()).build();

}
}
