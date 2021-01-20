package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
public class Preceptor extends User {

    private String statusRelacionamento;
    private String afiliacao;

    @ManyToOne
    @JoinColumn(name = "nucleo_id")
    private Nucleo nucleo;

    public Preceptor(Long ID, String name, int age, String genero, LocalDate birthday, boolean active, String statusRelacionamento, String afiliacao) {
        super(ID, name, age, genero, birthday, active);
        this.statusRelacionamento = statusRelacionamento;
        this.afiliacao = afiliacao;
    }
}
