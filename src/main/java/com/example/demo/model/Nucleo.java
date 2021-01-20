package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Nucleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String nome;
    private String cidade;

    @OneToMany(mappedBy = "nucleo", targetEntity = Apejotista.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Apejotista> apejotistas;

    @OneToMany(mappedBy = "nucleo", targetEntity = Preceptor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Preceptor> preceptores;
}
