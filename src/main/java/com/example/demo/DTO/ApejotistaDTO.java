package com.example.demo.DTO;

import com.example.demo.model.Apejotista;
import com.example.demo.model.Cargos;
import com.example.demo.model.Nucleo;
import com.example.demo.repository.NucleoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ApejotistaDTO {

    private Long ID;
    private String name;
    private int age;
    private String genero;
    private LocalDate birthday;
    private boolean active;
    private boolean ingresso;
    private Cargos cargos;
    private Long idNucleo;

    @Autowired
    private NucleoRepository nucleoRepository;

    public ApejotistaDTO(Long ID, String name, int age, String genero, LocalDate birthday, boolean active, boolean ingresso, Cargos cargos, Long idNucleo) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.genero = genero;
        this.birthday = birthday;
        this.active = active;
        this.ingresso = ingresso;
        this.cargos = cargos;
        this.idNucleo = idNucleo;
    }

    public Nucleo getNucleoByID(Long idNucleo) {
        Nucleo nucleo = nucleoRepository.findById(idNucleo).get();
        return nucleo;
    }
    

    public Apejotista apejotistaObjeto(){
        return new Apejotista(this.getName(), this.getAge(), this.getGenero(), this.getBirthday(),
                this.isActive(), this.isIngresso(), this.getCargos(), this.getNucleoByID(idNucleo));
    }

    public static ApejotistaDTO apejotistaDTO(Apejotista apejotista){

        Long idNucleo = apejotista.getIdByNucleo(apejotista.getNucleo());

        return new ApejotistaDTO(apejotista.getID(), apejotista.getName(), apejotista.getAge(),
                apejotista.getGenero(), apejotista.getBirthday(), apejotista.isActive(), apejotista.isIngressou(),
                apejotista.getCargo(), idNucleo);
    }

}
