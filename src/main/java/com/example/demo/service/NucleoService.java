package com.example.demo.service;


import com.example.demo.DTO.NucleoDTO;
import com.example.demo.DTO.mapper.NucleoMapper;
import com.example.demo.model.Nucleo;
import com.example.demo.repository.NucleoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NucleoService {

    private NucleoRepository nucleoRepository;

    public NucleoService(NucleoRepository nucleoRepository) {
        this.nucleoRepository = nucleoRepository;
    }

    public List<NucleoDTO> getNucleo(){

        List<Nucleo> nucleos = (List<Nucleo>) nucleoRepository.findAll();

        List<NucleoDTO> nucleoDTOS = new ArrayList<>();

        for (Nucleo nucleo : nucleos) {
            NucleoDTO newNucleoDTO = new NucleoDTO();

            newNucleoDTO.setID(nucleo.getID());
            newNucleoDTO.setName(nucleo.getName());
            newNucleoDTO.setNumber(nucleo.getNumber());
            newNucleoDTO.setCity(nucleo.getCity());
            newNucleoDTO.setActive(nucleo.isActive());

            nucleoDTOS.add(newNucleoDTO);
        }

        return nucleoDTOS;
    }

    public Nucleo salvar(Nucleo nucleo) {
        return nucleoRepository.save(nucleo);
    }

    public NucleoDTO getNucleoById(Long id){
        Nucleo nucleo = nucleoRepository.findById(id).orElse(null);

        NucleoDTO nucleoDTO = new NucleoDTO();

        nucleoDTO.setID(nucleo.getID());
        nucleoDTO.setName(nucleo.getName());
        nucleoDTO.setNumber(nucleo.getNumber());
        nucleoDTO.setCity(nucleo.getCity());
        nucleoDTO.setActive(nucleo.isActive());

        return nucleoDTO;
    }

    public NucleoDTO criarNucleo(NucleoDTO nucleoDTO) {
        Nucleo nucleo = NucleoMapper.toNucleo(nucleoDTO);
        Nucleo savedNucleo = nucleoRepository.save(nucleo);

        return NucleoMapper.toNucleoDTO(savedNucleo);
    }

    public void remover(Long id) {
        Nucleo one = nucleoRepository.findById(id).orElse(null);
        one.setActive(false);
        nucleoRepository.save(one);
    }


}
