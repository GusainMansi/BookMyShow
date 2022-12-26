package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Enum.TheatreType;
import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.Model.TheatreSeatEntity;

import com.example.BookMyShow.Model.TheatreSeatEntity;
import com.example.BookMyShow.Repository.TheatreEntityRepository;

import com.example.BookMyShow.Repository.TheatreEntityRepository;
import com.example.BookMyShow.Repository.TheatreSeatEntityRepository;

import com.example.BookMyShow.Service.TheatreService;
import com.example.BookMyShow.converter.TheatreConverter;

import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;

import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreEntityRepository theatreRepository;

    @Autowired
    TheatreSeatEntityRepository theatreSeatsRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theaterEntryDto) {

        TheatreEntity theatreEntity = TheatreConverter.dtoToEntity(theaterEntryDto);


        //create the Seats
        List<TheatreSeatEntity> seats = createTheaterSeats();


        theatreEntity.setSeats(seats);
        //I need to set the theaterId for all these seats

        theatreEntity.setShows(null);

        for(TheatreSeatEntity theatreSeatsEntity:seats){
            theatreSeatsEntity.setTheatre(theatreEntity);
        }
        theatreEntity.setType(TheatreType.SINGLE);

        log.info("The theater entity is "+ theatreEntity);

        theatreEntity = theatreRepository.save(theatreEntity);
         theatreSeatsRepository.saveAll(seats);
        TheatreResponseDto theaterResponseDto = TheatreConverter.entityToDto(theatreEntity);


        return theaterResponseDto;

    }

    List<TheatreSeatEntity> createTheaterSeats(){


        List<TheatreSeatEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",100,SeatType.PREMIUM));


        theatreSeatsRepository.saveAll(seats);

        return seats;
        //Add in this TheaterSeatEntity type

    }

    TheatreSeatEntity getTheaterSeat(String seatName, int rate, SeatType seatType){

        return TheatreSeatEntity.builder().seatNo(seatName).rate(rate).seatType(seatType).build();
    }

    //Seperate function will be create...


    @Override

    public TheatreResponseDto getTheatre(int id) {

        TheatreEntity theatreEntity = theatreRepository.findById(id).get();

        TheatreResponseDto theaterResponseDto = TheatreConverter.entityToDto(theatreEntity);

        return theaterResponseDto;
    }
}