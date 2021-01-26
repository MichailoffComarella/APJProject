package com.example.demo.controller;

import com.example.demo.DTO.PreceptorDTO;
import com.example.demo.service.PreceptorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/preceptores")
public class PreceptorController {

    private final PreceptorService preceptorService;

    @GetMapping
    public ResponseEntity<List<PreceptorDTO>> getPreceptores(){
        return new ResponseEntity<List<PreceptorDTO>>(preceptorService.getPreceptores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreceptorDTO> getPreceptores(@PathVariable Long id){
        return ResponseEntity.ok(preceptorService.getPreceptoresById(id));
    }

    @PostMapping
    public ResponseEntity<PreceptorDTO> salvar(@RequestBody PreceptorDTO dto) {
        preceptorService.criarPreceptor(dto);
        return ResponseEntity.created(URI.create("/preceptores/" + dto.getID())).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removerPreceptor(@PathVariable("id") Long id) {
        preceptorService.remover(Long.valueOf(id));
    }

}
