package com.example.demo.controller;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.model.Programa;
import com.example.demo.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {
    @Autowired
    ProgramaService programaService;

    @GetMapping
    public List<Programa> getMentoresAtivos(){
        return programaService.getProgramasAtivos();
    }

    @GetMapping("/inativos")
    public List<Programa> getMentoresInativos(){
        return programaService.getProgramasInativos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaDTO> getAluno(@PathVariable Long id) {
        return programaService.getProgramaByIndex(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProgramaDTO> criaMentor(@RequestBody ProgramaDTO programaDTO){
        return programaService.criaPrograma(programaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaDTO> atualizarMentor(@PathVariable("id") Long id, @RequestBody ProgramaDTO programaDTO){
        return programaService.atualizarPrograma(id, programaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/ativar/{id}")
    public ResponseEntity<ProgramaDTO> ativarAluno(@PathVariable("id") Long id) {
        return programaService.ativarPrograma(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgramaDTO> deletarAluno(@PathVariable Long id){
        return programaService.deletarPrograma(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
