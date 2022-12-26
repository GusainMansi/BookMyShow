package com.example.BookMyShow.Service;

import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.dto.BookRequestDto;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.dto.TicketDto;

public interface TicketService {
TicketResponseDto bookTicket(BookRequestDto bookRequestDto);
TicketResponseDto getTicket(int id);
    }
