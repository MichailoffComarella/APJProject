package com.example.demo.DTO.mapper;

import com.example.demo.DTO.NucleoDTO;
import com.example.demo.model.Nucleo;

public class NucleoMapper {

    public static Nucleo toNucleo(NucleoDTO nucleoDTO) {

        Nucleo nucleo = new Nucleo(nucleoDTO.getName(), nucleoDTO.getNumber(), nucleoDTO.getCity(), nucleoDTO.isActive());

        nucleo.setID(nucleoDTO.getID());

        return nucleo;
    }

    public static NucleoDTO toNucleoDTO(Nucleo nucleo){
        return new NucleoDTO(nucleo.getID(), nucleo.getName(), nucleo.getNumber(), nucleo.getCity(), nucleo.isActive());
    }
}
