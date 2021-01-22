package com.example.demo.service;


import com.example.demo.model.Nucleo;
import com.example.demo.repository.NucleoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NucleoService {

    private NucleoRepository nucleoRepository;

    public NucleoService(NucleoRepository nucleoRepository) {
        this.nucleoRepository = nucleoRepository;
    }

    public List<Nucleo> getNucleo(){

        List<Nucleo> nucleos = (List<Nucleo>) nucleoRepository.findAll();

        return nucleos;
    }

    public Nucleo salvar(Nucleo nucleo) {
        return nucleoRepository.save(nucleo);
    }

    public Nucleo getNucleoById(Long id){
        Nucleo nucleo = nucleoRepository.findById(id).orElse(null);

        return nucleo;
    }

    public Nucleo criarNucleo(Nucleo nucleo) {
        Nucleo savedNucleo = nucleoRepository.save(nucleo);

        return nucleo;
    }

    public void remover(Long id) {
        Nucleo one = nucleoRepository.findById(id).orElse(null);
        one.setActive(false);
    }


}
