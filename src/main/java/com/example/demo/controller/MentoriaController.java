package com.example.demo.controller;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.model.Mentoria;
import com.example.demo.service.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    MentoriaService mentoriaService;

    @GetMapping
    public List<Mentoria> getAlunos(){
        return mentoriaService.getMentorias();
    }

    @PostMapping
    public ResponseEntity<MentoriaDTO> criaMentoria(@RequestBody MentoriaDTO mentoriaDTO){
        return mentoriaService.criarMentoria(mentoriaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@PostMapping
    public ResponseEntity<AlunoDTO> criaAluno(@RequestBody AlunoDTO alunoDTO) {
        return alunoService.criaAluno(alunoDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        return alunoService.atualizarAluno(id, alunoDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<AlunoDTO> deletarAluno(@PathVariable Long id) {
        return alunoService.deletarAluno(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    }*/
}
