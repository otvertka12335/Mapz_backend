package com.mapz.controller;

import com.mapz.model.Hall;
import com.mapz.repo.HallRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/halls")
public class HallController {
    @Autowired
    private HallRepo genreRepo;

    @GetMapping
    public Iterable<Hall> getAll() {
        return genreRepo.findAll();
    }

    @PostMapping()
    public Hall save(@RequestBody final Hall hall) {
        genreRepo.save(hall);
        return hall;
    }

    @GetMapping("/{id}")
    public Hall find(@PathVariable("id") Hall hall) {
        return hall;
    }

    @PutMapping("/{id}")
    public Hall edit(@PathVariable("id") Hall hall,
                     @RequestBody Hall newHall) {
        BeanUtils.copyProperties(newHall, hall, "id");
        return genreRepo.save(hall);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Hall hall) {
        genreRepo.delete(hall);
    }
}
