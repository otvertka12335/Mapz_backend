package com.mapz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "halls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hall implements iCopy{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Hall(String name) {
        this.name = name;
    }
//Prototype
    @Override
    public Object copy() {
        Hall copy = new Hall(name);
        return copy;
    }
}
