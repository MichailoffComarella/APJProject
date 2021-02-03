package com.example.demo.service;

import com.example.demo.DTO.ApejotistaDTO;
import com.example.demo.DTO.mapper.ApejotistaMapper;
import com.example.demo.model.Apejotista;
import com.example.demo.repository.ApejotistaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApejotistaService {

    private ApejotistaRepository apejotistaRepository;

    public ApejotistaService(ApejotistaRepository apejotistaRepository) {
        this.apejotistaRepository = apejotistaRepository;
    }

    public List<ApejotistaDTO> getApejotistas(){

        List<Apejotista> apejotistas = (List<Apejotista>) apejotistaRepository.findAll();

        List<ApejotistaDTO> apejotistaDTOS = new ArrayList<>();

        for (Apejotista apejotista : apejotistas) {
            ApejotistaDTO newApejotistaDTO = new ApejotistaDTO();

            newApejotistaDTO.setName(apejotista.getName());
            newApejotistaDTO.setAge(apejotista.getAge());
            newApejotistaDTO.setGenero(apejotista.getGenero());
            newApejotistaDTO.setBirthday(apejotista.getBirthday());
            newApejotistaDTO.setActive(apejotista.isActive());
            newApejotistaDTO.setIngresso(apejotista.isIngressou());
            newApejotistaDTO.setCargos(apejotista.getCargo());
            newApejotistaDTO.setIdNucleo(apejotista.getIdByNucleo(apejotista.getNucleo()));
            newApejotistaDTO.setID(apejotista.getID());

            apejotistaDTOS.add(newApejotistaDTO);

        }

        return apejotistaDTOS;

    }

    public Apejotista salvar(Apejotista apejotista) {
        return apejotistaRepository.save(apejotista);
    }

    public ApejotistaDTO getApejotistaById(Long id){
        Apejotista apejotista = apejotistaRepository.findById(id).orElse(null);

        ApejotistaDTO apejotistaDTO = new ApejotistaDTO();

        apejotistaDTO.setName(apejotista.getName());
        apejotistaDTO.setAge(apejotista.getAge());
        apejotistaDTO.setGenero(apejotista.getGenero());
        apejotistaDTO.setBirthday(apejotista.getBirthday());
        apejotistaDTO.setActive(apejotista.isActive());
        apejotistaDTO.setIngresso(apejotista.isIngressou());
        apejotistaDTO.setCargos(apejotista.getCargo());
        apejotistaDTO.setIdNucleo(apejotista.getIdByNucleo(apejotista.getNucleo()));
        apejotistaDTO.setID(apejotista.getID());

        return apejotistaDTO;
    }

    private ApejotistaMapper mapper = Mappers.getMapper(ApejotistaMapper.class);

    public ApejotistaDTO criarApejotista(ApejotistaDTO apejotistaDTO) {
        Apejotista apejotista = mapper.apejotistaDTOtoApejotista(apejotistaDTO);
        Apejotista savedApejotista = apejotistaRepository.save(apejotista);

        return mapper.apejotistaToApejotistaDTO(apejotista);
    }

    public void remover(Long id) {
        Apejotista apj = apejotistaRepository.findById(id).orElse(null);
        apj.setActive(false);
        apejotistaRepository.save(apj);
    }

}
