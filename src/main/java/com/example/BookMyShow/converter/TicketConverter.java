package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.dto.TicketDto;
import lombok.experimental.UtilityClass;

import java.util.Collections;

@UtilityClass
public class TicketConverter {
    public static TicketEntity dtoToEntity(TicketDto ticketDto){
        return TicketEntity.builder().amount(ticketDto.getAmount()).alloted_seat(ticketDto.getAlloted_seat().toString()).build();

    }

    public static TicketResponseDto entityToDto(TicketEntity ticketEntity){
        return TicketResponseDto.builder().id((int)ticketEntity.getId()).amount(ticketEntity.getAmount()).
        alloted_seat(ticketEntity.getAlloted_seat()).build();
    }
}
