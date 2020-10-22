package com.example.demo.controller;

import com.example.demo.model.Mentor;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @GetMapping
    public List<Mentor> getMentores(){
        return mentorService.getMentores();
    }

    @PostMapping
    public ResponseEntity<Mentor> criaMentor(@RequestBody Mentor mentor){
        mentorService.criaMentor(mentor);
        return ResponseEntity.ok(mentor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Mentor>> atualizarMentor(@PathVariable("id") Long id, @RequestBody Mentor mentor){
        return ResponseEntity.ok().body(mentorService.atualizarMentor(id, mentor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Object>> deletarAluno(@PathVariable Long id){
        return ResponseEntity.ok().body(mentorService.deletarMentor(id));
    }
}
