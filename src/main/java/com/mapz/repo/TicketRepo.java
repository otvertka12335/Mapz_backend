package com.mapz.repo;

import com.mapz.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepo extends CrudRepository<Ticket, Integer> {
}
