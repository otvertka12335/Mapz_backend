package com.mapz.repo;

import com.mapz.model.PurchasedTicket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PurchasedTicketRepo extends CrudRepository<PurchasedTicket, Integer> {
    @Query(value = "SELECT * FROM purchased_tickets WHERE id_usr = :id AND status <> true", nativeQuery = true)
    Iterable<PurchasedTicket> findAllByUserId(@Param("id") int id);


    @Query(value = "SELECT * FROM purchased_tickets WHERE id_usr = :id AND status = true", nativeQuery = true)
    Iterable<PurchasedTicket> findAllByUserIdArchived(@Param("id") int id);

    @Query(value = "UPDATE purchased_tickets SET status = true WHERE id = :id", nativeQuery = true)
    PurchasedTicket setStatusTrue(@Param("id") int id);

    @Query(value = "delete from purchased_tickets " +
            "where purchased_tickets.id_tickets in " +
            "(select tickets.id from tickets where tickets.id_films = :film_id)", nativeQuery = true)
    void deleteAFilm(@Param("film_id") int id);
}
