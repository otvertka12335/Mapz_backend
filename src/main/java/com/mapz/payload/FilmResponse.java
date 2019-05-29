package com.mapz.payload;

import com.mapz.model.iFilm;

public class FilmResponse implements iFilm {
    private String name;
    private String description;

    public FilmResponse() {
    }

    public FilmResponse(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
