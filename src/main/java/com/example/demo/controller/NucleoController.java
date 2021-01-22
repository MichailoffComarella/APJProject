package com.example.demo.controller;

import com.example.demo.model.Nucleo;
import com.example.demo.service.NucleoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/nucleos")
public class NucleoController {

    private final NucleoService nucleoService;

    @GetMapping
    public ResponseEntity<List<Nucleo>> getNucleos(){
        return new ResponseEntity<List<Nucleo>>(nucleoService.getNucleo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nucleo> getNucleos(@PathVariable Long id){
        return ResponseEntity.ok(nucleoService.getNucleoById(id));
    }

    @PostMapping
    public ResponseEntity<Nucleo> salvar(@RequestBody Nucleo nucleo) {
        nucleoService.criarNucleo(nucleo);
        return ResponseEntity.created(URI.create("/nucleos/" + nucleo.getID())).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removerNucleo (@PathVariable("id") Long id) {
        nucleoService.remover(Long.valueOf(id));
    }

}
