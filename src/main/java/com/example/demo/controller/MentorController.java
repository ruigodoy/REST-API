package com.example.demo.controller;

import com.example.demo.dto.MentorDTO;
import com.example.demo.model.Mentor;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @GetMapping
    public List<Mentor> getMentoresAtivos(){
        return mentorService.getMentoresAtivos();
    }

    @GetMapping("/inativos")
    public List<Mentor> getMentoresInativos(){
        return mentorService.getMentoresInativos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getAluno(@PathVariable Long id) {
        return mentorService.getMentorByIndex(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MentorDTO> criaMentor(@RequestBody MentorDTO mentorDTO){
        return mentorService.criaMentor(mentorDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorDTO> atualizarMentor(@PathVariable("id") Long id, @RequestBody MentorDTO mentorDTO){
        return mentorService.atualizarMentor(id, mentorDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/ativar/{id}")
    public ResponseEntity<MentorDTO> ativarAluno(@PathVariable("id") Long id) {
        return mentorService.ativarMentor(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentorDTO> deletarAluno(@PathVariable Long id){
        return mentorService.deletarMentor(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
