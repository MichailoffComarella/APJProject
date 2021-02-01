package com.example.demo.controller;

import com.example.demo.DTO.NucleoDTO;
import com.example.demo.model.Nucleo;
import com.example.demo.service.NucleoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/nucleos")
public class NucleoController {

    @Autowired
    private NucleoService nucleoService;

    @GetMapping
    public ResponseEntity<List<NucleoDTO>> getNucleos(){
        return new ResponseEntity<List<NucleoDTO>>(nucleoService.getNucleo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NucleoDTO> getNucleos(@PathVariable Long id){
        return ResponseEntity.ok(nucleoService.getNucleoById(id));
    }

    @PostMapping
    public ResponseEntity<NucleoDTO> salvar(@RequestBody NucleoDTO dto) {
        nucleoService.criarNucleo(dto);
        return ResponseEntity.created(URI.create("/nucleos/" + dto.getID())).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removerNucleo (@PathVariable("id") Long id) {
        nucleoService.remover(Long.valueOf(id));
    }

}
