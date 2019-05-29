package com.mapz.service;

import com.mapz.model.iFilm;
import com.mapz.payload.FilmResponse;

public class JustFilm implements FilmFactory {
    @Override
    public iFilm createFilm() {
        return new FilmResponse();
    }
}
