package com.mapz.repo;

import com.mapz.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends CrudRepository<Ticket, Integer> {
    @Query(value = "SELECT * FROM tickets WHERE id_films = :id", nativeQuery = true)
    List<Ticket> getAll(@Param("id")int id);
}
