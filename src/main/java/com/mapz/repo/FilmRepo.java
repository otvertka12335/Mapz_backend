package com.mapz.repo;

import com.mapz.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmRepo extends JpaRepository<Film, Integer> {
    @Query(value = "SELECT * FROM films " +
            "WHERE del=false AND UPPER(name) LIKE UPPER(CONCAT('%', :search, '%'))", nativeQuery = true)
    Iterable<Film> findAllByName(@Param("search") String search);

    @Query(value = "SELECT * FROM films " +
//            "INNER JOIN films f on films_genres.film_id = f.id " +
            "INNER JOIN genres g on genre_id = g.id " +
            "WHERE del=false AND UPPER(g.name) LIKE UPPER(CONCAT('%', :search, '%'))", nativeQuery = true)
    Iterable<Film> findAllByGenres(@Param("search") String search);

    Iterable<Film> findAllByDelFalse();
}
