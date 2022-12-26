package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.ShowService;
import com.example.BookMyShow.converter.ShowConverter;

import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j //Helps
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreEntityRepository theatreRepository;

    @Autowired
    ShowSeatRepository showSeatsRepository;

    @Autowired
    ShowEntityRepository showRepository;

    @Override
    public  ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity = ShowConverter.dtoToEntity(showEntryDto);

        //MovieEntity
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheatreEntity theatreEntity = theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();


        showEntity.setMovie(movieEntity); //Why are we setting these varibble
        showEntity.setTheatre(theatreEntity);

        showEntity = showRepository.save(showEntity);


        //We need to pass the list of the theater seats
     List<ShowSeatsEntity>showSeatsEntityList=   generateShowEntitySeats(theatreEntity.getSeats(),showEntity);

showSeatsRepository.saveAll(showSeatsEntityList);

        //We need to create Response Show Dto.

        ShowResponseDto showResponseDto = ShowConverter.entityToDto(showEntity,showEntryDto);

        return showResponseDto;
    }

    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheatreSeatEntity> theaterSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        //log.info(String.valueOf(theaterSeatsEntityList));
//        log.info("The list of theaterEntity Seats");
//        for(TheaterSeatsEntity tse: theaterSeatsEntityList){
//            log.info(tse.toString());
//        }


        for(TheatreSeatEntity tse : theaterSeatsEntityList){

            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNo(tse.getSeatNo())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }


        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showSeatsRepository.saveAll(showSeatsEntityList);


        showEntity.setSeats(showSeatsEntityList);
        return showSeatsEntityList;

    }
    @Override
    public ShowResponseDto getShow(int id,ShowEntryDto showEntryDto){
        ShowEntity user=new ShowEntity();
        ShowEntity showEntity=  showRepository.findById(id).get();

        ShowResponseDto showResponseDto= ShowConverter.entityToDto(showEntity,showEntryDto);
        return showResponseDto;
    }

}
