package com.example.BookMyShow.dto.ResponseDto;

import com.example.BookMyShow.dto.TicketDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class UserResponseDto {
    int id;
    String name;
    String mobileNo;
    List<TicketDto> tickets;
}
