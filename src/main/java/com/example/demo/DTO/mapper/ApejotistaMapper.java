package com.example.demo.DTO.mapper;

import com.example.demo.DTO.ApejotistaDTO;
import com.example.demo.model.Apejotista;
import com.example.demo.model.Nucleo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApejotistaMapper {

    ApejotistaDTO apejotistaToApejotistaDTO(Apejotista apejotista);
    Apejotista apejotistaDTOtoApejotista(ApejotistaDTO apejotistaDTO);

}
