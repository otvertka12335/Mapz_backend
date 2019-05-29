package com.mapz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    private Genre(GenreBuilder builder) {
        this.name = builder.name;
    }

    public static class GenreBuilder {
        private String name;

        public String getName() {
            return name;
        }

        public GenreBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }
}
