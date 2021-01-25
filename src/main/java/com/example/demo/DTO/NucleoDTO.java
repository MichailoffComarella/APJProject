package com.example.demo.DTO;

import com.example.demo.model.Nucleo;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NucleoDTO {

    private Long ID;
    private String name;
    private int number;
    private String city;
    private boolean active;

    public NucleoDTO(Long ID, String name, int number, String city, boolean active) {
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.city = city;
        this.active = active;
    }

    public Nucleo nucleoObjeto(){
        return new Nucleo(this.getName(), this.getNumber(), this.getCity(), this.isActive());
    }

    public static NucleoDTO nucleoDTO(Nucleo nucleo) {

        return new NucleoDTO(nucleo.getID(), nucleo.getName(), nucleo.getNumber(), nucleo.getCity(), nucleo.isActive());

    }

}
