package com.mapz.controller;

import com.mapz.model.Film;
import com.mapz.repo.FilmRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/films")
public class FilmController {
    @Autowired
    private FilmRepo filmRepo;

    @GetMapping
    public Iterable<Film> getAll() {
        return filmRepo.findAll();
    }

    @PostMapping()
    public Film save(@RequestBody final Film film) {
        filmRepo.save(film);
        return film;
    }

    @GetMapping("/{id}")
    public Film find(@PathVariable("id") Film film) {
        return film;
    }

    @PutMapping("/{id}")
    public Film edit(@PathVariable("id") Film film,
                     @RequestBody Film newFilm) {
        BeanUtils.copyProperties(newFilm, film, "id");
        return filmRepo.save(film);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Film film) {
        filmRepo.delete(film);
    }

    @RequestMapping("/findAllByName")
    public Iterable<Film> findAllByName(@RequestParam("search") String search) {
        return filmRepo.findAllByName(search);
    }

    @RequestMapping("/findAllByGenre")
    public Iterable<Film> findAllByGenre(@RequestParam("search") String search) {
        return filmRepo.findAllByGenres(search);
    }
}
