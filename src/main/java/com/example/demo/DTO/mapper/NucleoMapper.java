package com.example.demo.DTO.mapper;

import com.example.demo.DTO.NucleoDTO;
import com.example.demo.model.Nucleo;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NucleoMapper {

    NucleoDTO nucleoToNucleoDTO(Nucleo nucleo);
    Nucleo nucleoDTOtoNucleo(NucleoDTO nucleoDTO);

}
