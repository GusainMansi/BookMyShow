package com.example.BookMyShow.dto;

import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
     int id;//ticket id
    Set<String> alloted_seat;
     double amount;
    ShowResponseDto showResponseDto;
    @NotNull
    UserResponseDto userResponseDto;


}
