package com.mapz.controller;


import com.mapz.model.Genre;
import com.mapz.repo.GenreRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/genres")
public class GenreController {
    @Autowired
    private GenreRepo genreRepo;

    @GetMapping
    public Iterable<Genre> getAll() {
        return genreRepo.findAll();
    }

    @PostMapping()
    public Genre save(@RequestBody final Genre genre) {
        genreRepo.save(genre);
        return genre;
    }

    @GetMapping("/{id}")
    public Genre find(@PathVariable("id") Genre genre) {
        return genre;
    }

    @PutMapping("/{id}")
    public Genre edit(@PathVariable("id") Genre genre,
                      @RequestBody Genre newGenre) {
        BeanUtils.copyProperties(newGenre, genre, "id");
        return genreRepo.save(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Genre genre) {
        genreRepo.delete(genre);
    }
}
