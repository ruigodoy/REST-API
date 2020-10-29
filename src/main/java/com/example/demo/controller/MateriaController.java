package com.example.demo.controller;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.dto.MentorDTO;
import com.example.demo.model.Materia;
import com.example.demo.model.Mentor;
import com.example.demo.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @GetMapping
    public List<Materia> getMateriasAtivos(){
        return materiaService.getMateriaAtivas();
    }

    @GetMapping("/inativos")
    public List<Materia> getMateriasInativos(){
        return materiaService.getMateriaInativas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateria(@PathVariable Long id) {
        return materiaService.getMateriaByIndex(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> criaMateria(@RequestBody MateriaDTO materiaDTO){
        return materiaService.criaMateria(materiaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> atualizarMateria(@PathVariable("id") Long id, @RequestBody MateriaDTO materiaDTO){
        return materiaService.atualizarMateria(id, materiaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/ativar/{id}")
    public ResponseEntity<MateriaDTO> ativarMateria(@PathVariable("id") Long id) {
        return materiaService.ativarMateria(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MateriaDTO> deletarMateria(@PathVariable Long id){
        return materiaService.deletarMateria(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
