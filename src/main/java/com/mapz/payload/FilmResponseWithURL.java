package com.mapz.payload;

import com.mapz.model.iFilm;

public class FilmResponseWithURL implements iFilm {
    private String name;
    private String description;
    private String url;

    public FilmResponseWithURL(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public FilmResponseWithURL() {
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
