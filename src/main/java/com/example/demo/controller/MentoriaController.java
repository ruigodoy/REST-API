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
    public List<Mentoria> getMentoresAtivos(){
        return mentoriaService.getMentoriasAtivas();
    }

    @GetMapping("/inativos")
    public List<Mentoria> getMentoresInativos(){
        return mentoriaService.getMentoriasInativas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentoriaDTO> getAluno(@PathVariable Long id) {
        return mentoriaService.getMentoriaByIndex(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MentoriaDTO> criaMentoria(@RequestBody MentoriaDTO mentoriaDTO){
        return mentoriaService.criarMentoria(mentoriaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentoriaDTO> atualizarMentor(@PathVariable("id") Long id, @RequestBody MentoriaDTO mentoriaDTO){
        return mentoriaService.atualizarMentoria(id, mentoriaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/ativar/{id}")
    public ResponseEntity<MentoriaDTO> ativarAluno(@PathVariable("id") Long id) {
        return mentoriaService.ativarMentoria(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentoriaDTO> deletarAluno(@PathVariable Long id){
        return mentoriaService.deletarMentoria(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
