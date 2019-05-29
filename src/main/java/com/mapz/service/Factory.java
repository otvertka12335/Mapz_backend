package com.mapz.service;

public class Factory {
    public static FilmFactory createFilm(String filmType) {
        if (filmType.equalsIgnoreCase("url")) {
            return new URLFilm();
        } else if (filmType.equalsIgnoreCase("just")) {
            return new JustFilm();
        } else {
            return null;
        }
    }
}
