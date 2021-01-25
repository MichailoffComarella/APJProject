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

    public Long getIdByNucleo(Nucleo nucleo){
        return nucleo.getID();
    }

    public Apejotista(String name, int age, String genero, LocalDate birthday, boolean active, boolean ingresso, Cargos cargo, Nucleo nucleo) {
        super(name, age, genero, birthday, active);
        this.ingressou = ingresso;
        this.cargo = cargo;
        this.nucleo = nucleo;
    }


}
