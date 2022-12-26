package com.example.BookMyShow.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private List<ShowDto> movieShow;
}
