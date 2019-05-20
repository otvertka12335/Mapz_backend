package com.mapz.repo;

import com.mapz.model.PurchasedTicket;
import org.springframework.data.repository.CrudRepository;

public interface PurchasedTicketRepo extends CrudRepository<PurchasedTicket, Integer> {
}
