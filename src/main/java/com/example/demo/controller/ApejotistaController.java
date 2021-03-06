package com.example.demo.controller;

import com.example.demo.DTO.ApejotistaDTO;
import com.example.demo.model.Apejotista;
import com.example.demo.model.Cargos;
import com.example.demo.repository.ApejotistaRepository;
import com.example.demo.service.ApejotistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apejotistas")
public class ApejotistaController {

    private final ApejotistaService apejotistaService;

    @GetMapping
    public ResponseEntity<List<ApejotistaDTO>> getApejotistas(){
        return new ResponseEntity<List<ApejotistaDTO>>(apejotistaService.getApejotistas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApejotistaDTO> getApejotistas(@PathVariable Long id){
        return ResponseEntity.ok(apejotistaService.getApejotistaById(id));
    }

    @PostMapping
    public ResponseEntity<ApejotistaDTO> salvar(@RequestBody ApejotistaDTO dto) {
        apejotistaService.criarApejotista(dto);
        return ResponseEntity.created(URI.create("/apejotistas/" + dto.getID())).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removerApejotista (@PathVariable("id") Long id) {
        apejotistaService.remover(Long.valueOf(id));
    }

}
