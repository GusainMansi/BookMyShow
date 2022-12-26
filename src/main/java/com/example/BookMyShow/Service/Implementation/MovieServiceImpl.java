package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.MovieDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
public MovieResponseDto addMovie(MovieEntryDto movieEntryDto){
    //find to search by name
        MovieResponseDto movieResponseDto = null;

        //if the movie is already created then we can throw an exception....movie already exists.
        if(movieRepository.existsByName(movieEntryDto.getName())){

            movieResponseDto.setName("We have this already:)");
            return movieResponseDto;
        }

        log.info("In the function add movie "+ movieEntryDto);


        //I need a movieEntity Object
        /*
                How can I get it
         */



        MovieEntity movieEntity = MovieConverter.dtoToEntity(movieEntryDto);


        movieEntity = movieRepository.save(movieEntity); //This will auto add the id variable
        //

        movieResponseDto = MovieConverter.entityToDto(movieEntity);

        return movieResponseDto; //It can be a response type of the movie

    }

@Override
    public MovieResponseDto getMovie(int id){

        // MovieEntity movie= new MovieEntity();
    //if i use the orElse feature then movie will be returned this above empty
        MovieEntity movieEntity=movieRepository.findById(id).get();//orElse(movie);
        MovieResponseDto movieDto=MovieConverter.entityToDto(movieEntity);
        return movieDto;
}
@Override
public MovieNameAndIdObject getNameAndId(int id){

    //I need information from repo
    MovieEntity movieEntity = movieRepository.findById(id).get(); //Get this movieEntity from the database


    //I have to convert it

    MovieNameAndIdObject obj = MovieConverter.convertEntityToThisObject(movieEntity);


    return obj;
}
}
