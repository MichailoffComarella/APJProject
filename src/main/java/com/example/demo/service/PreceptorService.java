package com.example.demo.service;

import com.example.demo.DTO.PreceptorDTO;
import com.example.demo.DTO.mapper.PreceptorMapper;
import com.example.demo.model.Preceptor;
import com.example.demo.repository.PreceptorRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreceptorService {

    private PreceptorRepository preceptorRepository;

    public PreceptorService(PreceptorRepository preceptorRepository){
        this.preceptorRepository = preceptorRepository;
    }

    public List<PreceptorDTO> getPreceptores(){

        List<Preceptor> preceptores = (List<Preceptor>) preceptorRepository.findAll();

        List<PreceptorDTO> preceptoresDTOS = new ArrayList<>();

        for (Preceptor preceptor : preceptores){
            PreceptorDTO newPreceptorDTO = new PreceptorDTO();

            newPreceptorDTO.setID(preceptor.getID());
            newPreceptorDTO.setName(preceptor.getName());
            newPreceptorDTO.setAge(preceptor.getAge());
            newPreceptorDTO.setGenero(preceptor.getGenero());
            newPreceptorDTO.setBirthday(preceptor.getBirthday());
            newPreceptorDTO.setActive(preceptor.isActive());
            newPreceptorDTO.setStatusRelacionamento(preceptor.getStatusRelacionamento());
            newPreceptorDTO.setAfiliacao(preceptor.getAfiliacao());
            newPreceptorDTO.setIdNucleo(preceptor.getIdByNucleo(preceptor.getNucleo()));

            preceptoresDTOS.add(newPreceptorDTO);

        }

        return preceptoresDTOS;

    }

    public Preceptor salvar(Preceptor preceptor){
        return preceptorRepository.save(preceptor);
    }

    public PreceptorDTO getPreceptoresById(Long id){
        Preceptor preceptor = preceptorRepository.findById(id).orElse(null);

        PreceptorDTO preceptorDTO = new PreceptorDTO();

        preceptorDTO.setID(preceptor.getID());
        preceptorDTO.setName(preceptor.getName());
        preceptorDTO.setAge(preceptor.getAge());
        preceptorDTO.setGenero(preceptor.getGenero());
        preceptorDTO.setBirthday(preceptor.getBirthday());
        preceptorDTO.setActive(preceptor.isActive());
        preceptorDTO.setStatusRelacionamento(preceptor.getStatusRelacionamento());
        preceptorDTO.setAfiliacao(preceptor.getAfiliacao());
        preceptorDTO.setIdNucleo(preceptor.getIdByNucleo(preceptor.getNucleo()));

        return preceptorDTO;
    }

    private PreceptorMapper mapper = Mappers.getMapper(PreceptorMapper.class);

    public PreceptorDTO criarPreceptor(PreceptorDTO preceptorDTO){
        Preceptor preceptor = mapper.preceptorDTOtoPreceptor(preceptorDTO);
        Preceptor savedPreceptor = preceptorRepository.save(preceptor);

        return mapper.preceptorToPreceptorDTO(preceptor);
    }

    public void remover(Long id){
        Preceptor apj = preceptorRepository.findById(id).orElse(null);
        apj.setActive(false);
        preceptorRepository.save(apj);
    }


}
