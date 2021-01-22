package com.example.demo.service;

import com.example.demo.model.Apejotista;
import com.example.demo.repository.ApejotistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApejotistaService {

    private ApejotistaRepository apejotistaRepository;

    public ApejotistaService(ApejotistaRepository apejotistaRepository) {
        this.apejotistaRepository = apejotistaRepository;
    }

    public List<Apejotista> getApejotistas(){

        List<Apejotista> apejotistas = (List<Apejotista>) apejotistaRepository.findAll();

        return apejotistas;

    }

    public Apejotista salvar(Apejotista apejotista) {
        return apejotistaRepository.save(apejotista);
    }

    public Apejotista getApejotistaById(Long id){
        Apejotista apejotista = apejotistaRepository.findById(id).orElse(null);

        return apejotista;
    }

    public Apejotista criarApejotista(Apejotista apejotista) {
        Apejotista savedApejotista = apejotistaRepository.save(apejotista);

        return apejotista;
    }

    public void remover(Long id) {
        Apejotista apj = apejotistaRepository.findById(id).orElse(null);
        apj.setActive(false);
        apejotistaRepository.save(apj);
    }

}
