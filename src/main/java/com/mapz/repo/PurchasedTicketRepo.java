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
}
