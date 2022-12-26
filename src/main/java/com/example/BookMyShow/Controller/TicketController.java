package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Service.Implementation.TicketServiceImpl;

import com.example.BookMyShow.dto.BookRequestDto;
import com.example.BookMyShow.dto.BookRequestDto;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("get/{id}")
    public TicketResponseDto getTicketById(@PathVariable Integer id){

        return ticketService.getTicket(id);
    }

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody() BookRequestDto bookTicketRequestDto){


        return ticketService.bookTicket(bookTicketRequestDto);

    }
}
