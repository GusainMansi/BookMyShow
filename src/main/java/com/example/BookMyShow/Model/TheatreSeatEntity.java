package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="theater_seats")
@Builder
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name="seatNo",nullable = false)

    private String seatNo;
    @Column(name="rate",nullable = false)

    private int rate;
    @Enumerated(EnumType.STRING)
    @Column(name="seat_type",nullable = false)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
   private TheatreEntity theatre;

}
