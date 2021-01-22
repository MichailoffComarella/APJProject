package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long ID;

    protected String name;
    protected int age;
    private String genero;
    protected LocalDate birthday;
    protected boolean active;

    public User(String name, int age, String genero, LocalDate birthday, boolean active) {
        this.name = name;
        this.age = age;
        this.genero = genero;
        this.birthday = birthday;
        this.active = active;
    }
}
