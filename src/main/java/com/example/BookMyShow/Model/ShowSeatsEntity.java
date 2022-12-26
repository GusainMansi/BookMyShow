package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="show_seats")
@Builder
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name="rate",nullable = false)

    private int rate;
    @Column(name="seat_number",nullable = false)

    private String seatNo;
    @Enumerated(EnumType.STRING)
    @Column(name="seat_type",nullable = false)

    private SeatType seatType;
    @Column(name="is_booked",columnDefinition = "bit(1)default 0",nullable = false)
    private boolean booked;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="booked_at")
    private Date bookedSeat;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TicketEntity ticket;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;

}
