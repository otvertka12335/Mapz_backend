package com.mapz.service;

import com.mapz.model.iFilm;
import com.mapz.payload.FilmResponseWithURL;

public class URLFilm implements FilmFactory {
    @Override
    public iFilm createFilm() {
        return new FilmResponseWithURL();
    }
}
