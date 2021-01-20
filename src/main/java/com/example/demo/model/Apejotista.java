package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Apejotista extends User {

    private boolean ingressou;
    private Cargos cargo;

    @ManyToOne
    @JoinColumn(name = "nucleo_id")
    private Nucleo nucleo;

    public Apejotista(Long ID, String name, int age, String genero, LocalDate birthday, boolean active, boolean ingresso, Cargos cargo) {
        super(ID, name, age, genero, birthday, active);
        this.ingressou = ingresso;
        this.cargo = cargo;
    }


}
