package com.mapz.repo;

import com.mapz.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmRepo extends JpaRepository<Film, Integer> {
    @Query(value = "SELECT * FROM films " +
            "WHERE UPPER(name) LIKE UPPER(CONCAT('%', :search, '%'))", nativeQuery = true)
    Iterable<Film> findAllByName(@Param("search") String search);

    @Query(value = "SELECT f.* FROM films_genres " +
            "INNER JOIN films f on films_genres.film_id = f.id " +
            "INNER JOIN genres g on films_genres.genres_id = g.id " +
            "WHERE UPPER(g.name) LIKE UPPER(CONCAT('%', :search, '%'))", nativeQuery = true)
    Iterable<Film> findAllByGenres(@Param("search") String search);
}
