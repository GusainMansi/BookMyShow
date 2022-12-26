package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.MovieDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    public static MovieEntity dtoToEntity(MovieEntryDto movieDto){
        return MovieEntity.builder().name(movieDto.getName()).releaseDate(movieDto.getReleaseDate()).build();
    }
    public static MovieResponseDto entityToDto(MovieEntity movieEntity){
        //i am fetching so id need to be accessed
        return MovieResponseDto.builder().name(movieEntity.getName()).id(movieEntity.getId()).releaseDate(movieEntity.getReleaseDate()).build();

    }
    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity){
        return  MovieNameAndIdObject.builder().id(movieEntity.getId()).name(movieEntity.getName()).build();
    }

}
