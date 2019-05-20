package com.mapz.repo;

import com.mapz.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepo extends CrudRepository<Genre, Integer> {
}
