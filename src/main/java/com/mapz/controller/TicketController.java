package com.mapz.controller;

import com.mapz.model.Ticket;
import com.mapz.repo.TicketRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketController {
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping
    public Iterable<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    @PostMapping()
    public Ticket save(@RequestBody final Ticket ticket) {
        ticketRepo.save(ticket);
        return ticket;
    }

    @GetMapping("/{id}")
    public Ticket find(@PathVariable("id") Ticket ticket) {
        return ticket;
    }

    @PutMapping("/{id}")
    public Ticket edit(@PathVariable("id") Ticket ticket,
                       @RequestBody Ticket newTicket) {
        BeanUtils.copyProperties(newTicket, ticket, "id");
        return ticketRepo.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Ticket ticket) {
        ticketRepo.delete(ticket);
    }

    @RequestMapping("/film")
    public List<Ticket> getAllByFilm(@RequestParam("id")int id) {
        return ticketRepo.getAll(id);
    }
}
