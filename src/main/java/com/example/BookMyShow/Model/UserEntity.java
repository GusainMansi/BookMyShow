package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name="users")
@Builder

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //means in table after first value the next value is 2 and so on counting does not vary
    //individual
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="name",nullable = false)

    private String name;
    @Column(name="mobile",nullable = false)

    private String mobile;
    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL)

   private List<TicketEntity> ticketEntities;
}
