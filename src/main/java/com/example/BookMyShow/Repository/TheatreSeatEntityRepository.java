package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatEntityRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
