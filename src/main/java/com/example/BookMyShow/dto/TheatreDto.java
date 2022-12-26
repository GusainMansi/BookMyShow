package com.example.BookMyShow.dto;

import com.example.BookMyShow.Enum.TheatreType;
import com.example.BookMyShow.Model.ShowEntity;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TheatreDto {
    private int id;
    private String name;
    private String address;
    private String city;
    TheatreType theatreType;
    ShowDto showDto;

}
