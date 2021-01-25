package com.example.demo.DTO.mapper;

import com.example.demo.DTO.ApejotistaDTO;
import com.example.demo.model.Apejotista;
import com.example.demo.model.Nucleo;

public class ApejotistaMapper {

    public static Apejotista toApejotista(ApejotistaDTO apejotistaDTO) {

        Nucleo nucleoAPJ = apejotistaDTO.getNucleoByID(apejotistaDTO.getIdNucleo());

        Apejotista apejotista = new Apejotista(apejotistaDTO.getName(), apejotistaDTO.getAge(), apejotistaDTO.getGenero(),
                apejotistaDTO.getBirthday(), apejotistaDTO.isActive(), apejotistaDTO.isIngresso(), apejotistaDTO.getCargos(),
                nucleoAPJ);
        apejotista.setID(apejotistaDTO.getID());

        return apejotista;
    }

    public static ApejotistaDTO toApejotistaDTO(Apejotista apejotista){

        Long idNucleo = apejotista.getIdByNucleo(apejotista.getNucleo());

        return new ApejotistaDTO(apejotista.getID(), apejotista.getName(), apejotista.getAge(),
                apejotista.getGenero(), apejotista.getBirthday(), apejotista.isActive(), apejotista.isIngressou(),
                apejotista.getCargo(), idNucleo);
    }
}
