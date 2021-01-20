package com.example.demo.controller;

import com.example.demo.model.Apejotista;
import com.example.demo.model.Cargos;
import com.example.demo.repository.ApejotistaRepository;
import com.example.demo.service.ApejotistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apejotistas")
public class ApejotistaController {

    private ApejotistaRepository apejotistaRepository;

    private ApejotistaService apejotistaService;

    @GetMapping
    public List<Apejotista> getApejotistas(){
        Apejotista apj1 = new Apejotista();
        Apejotista apj2 = new Apejotista();
        Apejotista apj3 = new Apejotista();

        apj1.setName("Milena");
        apj2.setName("João Pedro");
        apj3.setName("Vitória");

        apj1.setAge(20);
        apj2.setAge(19);
        apj3.setAge(18);

        apj1.setGenero("Feminino");
        apj2.setGenero("Masculino");
        apj3.setGenero("Feminino");

        apj1.setBirthday(LocalDate.of(2001,02,15));
        apj2.setBirthday(LocalDate.of(2002, 06,19));
        apj3.setBirthday(LocalDate.of(2003, 05, 20));

        apj1.setActive(true);
        apj2.setActive(true);
        apj3.setActive(true);

        apj1.setIngressou(true);
        apj2.setIngressou(true);
        apj3.setIngressou(true);

        apj1.setCargo(Cargos.PRELETOR);
        apj2.setCargo(Cargos.DUCTOR);
        apj3.setCargo(Cargos.ESCRIBA);

        List<Apejotista> apejotistas = new ArrayList<>();

        apejotistas.add(apj1);
        apejotistas.add(apj2);
        apejotistas.add(apj3);

        return apejotistas;
    }

}
