package com.mapz.repo;

import com.mapz.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepo extends CrudRepository<Film, Integer> {
}
