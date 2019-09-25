package com.mapz.repo;

import com.mapz.model.Film;
import com.mapz.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends CrudRepository<Ticket, Integer> {
    @Query(value = "SELECT * FROM tickets WHERE id_films = :id", nativeQuery = true)
    List<Ticket> getAll(@Param("id")int id);

    @Query(value = "delete from tickets where id_films = :film_id", nativeQuery = true)
    void deleteAFilm(@Param("film_id") int id);
}
