package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
