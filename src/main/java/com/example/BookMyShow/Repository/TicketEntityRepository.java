package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketEntityRepository extends JpaRepository<TicketEntity,Integer> {
}
