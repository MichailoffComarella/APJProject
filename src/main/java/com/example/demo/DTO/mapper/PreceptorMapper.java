package com.example.demo.DTO.mapper;

import com.example.demo.DTO.PreceptorDTO;
import com.example.demo.model.Nucleo;
import com.example.demo.model.Preceptor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreceptorMapper {

   PreceptorDTO preceptorToPreceptorDTO(Preceptor preceptor);
   Preceptor preceptorDTOtoPreceptor(PreceptorDTO preceptorDTO);


}
