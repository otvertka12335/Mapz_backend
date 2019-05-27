package com.mapz.controller;

import com.mapz.model.PurchasedTicket;
import com.mapz.repo.PurchasedTicketRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/purchased")
public class PurchasedTicketController {
    @Autowired
    private PurchasedTicketRepo purchasedTicketRepo;

    @GetMapping
    public Iterable<PurchasedTicket> getAll() {
        return purchasedTicketRepo.findAll();
    }

    @PostMapping()
    public PurchasedTicket save(@RequestBody final PurchasedTicket purchasedTicket) {
        purchasedTicketRepo.save(purchasedTicket);
        return purchasedTicket;
    }

    @GetMapping("/{id}")
    public PurchasedTicket find(@PathVariable("id") PurchasedTicket purchasedTicket) {
        return purchasedTicket;
    }

    @PutMapping("/{id}")
    public PurchasedTicket edit(@PathVariable("id") PurchasedTicket purchasedTicket,
                                @RequestBody PurchasedTicket newPurchased) {
        BeanUtils.copyProperties(newPurchased, purchasedTicket, "id");
        return purchasedTicketRepo.save(purchasedTicket);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") PurchasedTicket purchasedTicket) {
        purchasedTicketRepo.delete(purchasedTicket);
    }

    @RequestMapping("/getAllByUser")
    public Iterable<PurchasedTicket> getAllByUserId(@RequestParam("id") int id) {
        return purchasedTicketRepo.findAllByUserId(id);
    }

    @RequestMapping("/getAllByUserArchived")
    public Iterable<PurchasedTicket> getAllByUserArchived(@RequestParam("id") int id) {
        return purchasedTicketRepo.findAllByUserIdArchived(id);
    }

    @PostMapping("/setStatusTrue/{id}")
    public void setStatusTrue(@PathVariable("id") int id) {
        purchasedTicketRepo.setStatusTrue(id);
    }
}
