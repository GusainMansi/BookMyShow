package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="theatres")
@Builder
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name="name",nullable = false)

    private String name;
    @Column(name="address",nullable = false)

    private String address;
    @Column(name="city",nullable = false)
    private String city;
    @OneToMany(mappedBy = "theatre",cascade=CascadeType.ALL)
            @JsonIgnore
    private List<ShowEntity> shows;
    TheatreType type;
    @OneToMany(mappedBy = "theatre",cascade=CascadeType.ALL)
    @JsonIgnore
  private  List<TheatreSeatEntity> seats=new ArrayList<>();





}
