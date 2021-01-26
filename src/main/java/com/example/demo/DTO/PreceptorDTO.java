package com.example.demo.DTO;

import com.example.demo.model.Apejotista;
import com.example.demo.model.Nucleo;
import com.example.demo.model.Preceptor;
import com.example.demo.repository.NucleoRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class PreceptorDTO {

    private Long ID;
    private String name;
    private int age;
    private String genero;
    private LocalDate birthday;
    private boolean active;
    private String statusRelacionamento;
    private String afiliacao;
    private Long idNucleo;

    @Autowired
    private NucleoRepository nucleoRepository;

    public PreceptorDTO(Long ID, String name, int age, String genero, LocalDate birthday, boolean active, String statusRelacionamento, String afiliacao, Long idNucleo) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.genero = genero;
        this.birthday = birthday;
        this.active = active;
        this.statusRelacionamento = statusRelacionamento;
        this.afiliacao = afiliacao;
        this.idNucleo = idNucleo;
    }

    public Nucleo getNucleoByID(Long idNucleo){
        Nucleo nucleo = nucleoRepository.findById(idNucleo).get();
        return nucleo;
    }

    public Preceptor preceptorObjeto(){
        return new Preceptor(this.getName(), this.getAge(), this.getGenero(), this.getBirthday(),
                this.isActive(), this.getStatusRelacionamento(), this.getAfiliacao(), this.getNucleoByID(idNucleo));
    }

    public PreceptorDTO preceptorDTO(Preceptor preceptor){
        Long idNucleo = preceptor.getIdByNucleo(preceptor.getNucleo());

        return new PreceptorDTO(preceptor.getID(), preceptor.getName(), preceptor.getAge(), preceptor.getGenero(),
                preceptor.getBirthday(), preceptor.isActive(), preceptor.getStatusRelacionamento(), preceptor.getAfiliacao(),
                idNucleo);
    }


}
