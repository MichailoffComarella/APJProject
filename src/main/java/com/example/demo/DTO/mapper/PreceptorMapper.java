package com.example.demo.DTO.mapper;

import com.example.demo.DTO.PreceptorDTO;
import com.example.demo.model.Nucleo;
import com.example.demo.model.Preceptor;

public class PreceptorMapper {

    public static Preceptor toPreceptor(PreceptorDTO preceptorDTO){

        Nucleo nucleoAPJ = preceptorDTO.getNucleoByID(preceptorDTO.getIdNucleo());

        Preceptor preceptor = new Preceptor(preceptorDTO.getName(), preceptorDTO.getAge(), preceptorDTO.getGenero(),
                preceptorDTO.getBirthday(), preceptorDTO.isActive(), preceptorDTO.getStatusRelacionamento(), preceptorDTO.getAfiliacao(),
                nucleoAPJ);

        preceptor.setID(preceptorDTO.getID());

        return preceptor;
    }

    public static PreceptorDTO toPreceptorDTO(Preceptor preceptor){

        Long idNucleo = preceptor.getIdByNucleo(preceptor.getNucleo());

        return new PreceptorDTO(preceptor.getID(), preceptor.getName(), preceptor.getAge(), preceptor.getGenero(),
                preceptor.getBirthday(), preceptor.isActive(), preceptor.getStatusRelacionamento(), preceptor.getAfiliacao(),
                idNucleo);
    }
}
