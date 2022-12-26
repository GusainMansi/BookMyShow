package com.example.BookMyShow.Service.Implementation;

import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Model.ShowEntity;
import com.example.BookMyShow.Model.ShowSeatsEntity;
import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Repository.ShowEntityRepository;
import com.example.BookMyShow.Repository.TicketEntityRepository;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Service.TicketService;
import com.example.BookMyShow.converter.ShowConverter;
import com.example.BookMyShow.converter.TicketConverter;
import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.BookRequestDto;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.dto.ShowDto;
import com.example.BookMyShow.dto.TicketDto;
import com.example.BookMyShow.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
   @Autowired
    UserRepository userRepository;
   @Autowired
    ShowEntityRepository showRepository;
   @Autowired
   TicketEntityRepository ticketRepository;

   @Override
   public TicketResponseDto getTicket(int id) {

       TicketEntity ticketEntity = ticketRepository.findById(id).get();

       UserConverter TicketConvertor;
       TicketResponseDto ticketResponseDto = TicketConverter.entityToDto(ticketEntity);

       return ticketResponseDto;

   }

    @Override
    public TicketResponseDto bookTicket(BookRequestDto bookRequestDto){


        UserEntity userEntity = userRepository.findById(bookRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookRequestDto.getShowId()).get();

        Set<String> requestSeats = bookRequestDto.getRequestedSeats();


        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();


//        //Another way to iterate. Try to study about it.
//        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
//                .stream()
//                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
//                        requestSeats.contains(seat.getSeatNumber()))
//                .collect(Collectors.toList());



        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat :showSeatsEntityList){

            if(!seat.isBooked()&&seat.getSeatType().equals(bookRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNo())){
                bookedSeats.add(seat);
            }
        }

        if(bookedSeats.size()!=requestSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        TicketEntity ticketEntity = TicketEntity.builder().user(userEntity).show(showEntity).seats(bookedSeats).build();



        //Step 3 :

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedSeat(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAlloted_seat(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);


        //Connect in thw Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketEntities().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        ShowConverter TicketConvertor;
        return TicketConverter.entityToDto(ticketEntity);


    }
    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNo()+" ";
        }

        return str;

    }

    }

