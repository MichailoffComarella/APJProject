package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Nucleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;
    private int number;
    private String city;
    public boolean active;

    @OneToMany(mappedBy = "nucleo", targetEntity = Apejotista.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Apejotista> apejotistas;

    @OneToMany(mappedBy = "nucleo", targetEntity = Preceptor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Preceptor> preceptores;

    public Nucleo(String name, int number, String city, boolean active) {
        this.name = name;
        this.number = number;
        this.city = city;
        this.active = active;

    }
}
