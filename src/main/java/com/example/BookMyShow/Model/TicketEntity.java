package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name="tickets")
@Builder

public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name="alloted_seats",nullable = false)

    private String alloted_seat;
    @Column(name="amount",nullable = false)

    private double amount;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="booked_at",nullable = false)
    private Date bookedAt;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
  private  UserEntity user;
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    @JsonIgnore
   private List<ShowSeatsEntity> seats;
    @ManyToOne
    @JoinColumn//unidirectional
    @JsonIgnore
    private ShowEntity show;


}
