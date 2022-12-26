package com.example.BookMyShow.dto;

import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Model.ShowSeatsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookRequestDto {
    int id;
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
