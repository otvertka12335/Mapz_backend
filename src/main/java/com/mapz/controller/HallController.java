package com.mapz.controller;

import com.mapz.model.Hall;
import com.mapz.model.Iterator;
import com.mapz.model.classIterator;
import com.mapz.repo.HallRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/halls")
public class HallController {
    @Autowired
    private HallRepo hallRepo;
    private classIterator classIterator = new classIterator();
    private Iterator iterator = classIterator.getIterator();

    @GetMapping
    public Iterable<Hall> getAll() {
        while(iterator.hasNext()) {
            return hallRepo.findAll();
        }
        return hallRepo.findAll();
    }

    @PostMapping()
    public Hall save(@RequestBody final Hall hall) {
        hallRepo.save(hall);
        return hall;
    }

    @GetMapping("/{id}")
    public Hall find(@PathVariable("id") Hall hall) {
        return hall;
    }

    @GetMapping("/c{id}")
    public Hall findC(@PathVariable("id") Hall hall) {
        return (Hall) hall.copy();
    }

    @PutMapping("/{id}")
    public Hall edit(@PathVariable("id") Hall hall,
                     @RequestBody Hall newHall) {
        BeanUtils.copyProperties(newHall, hall, "id");
        return hallRepo.save(hall);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Hall hall) {
        hallRepo.delete(hall);
    }
}
