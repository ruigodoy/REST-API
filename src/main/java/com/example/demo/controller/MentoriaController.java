package com.example.demo.controller;

import com.example.demo.dto.MentoriaDTO;
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
    public List<MentoriaDTO> getAlunos(){
        return mentoriaService.getMentorias();
    }

    @PostMapping
    public ResponseEntity<MentoriaDTO> criaMentoria(@RequestBody MentoriaDTO dto){
        return ResponseEntity.ok().body(mentoriaService.criarMentoria(dto));
    }
}
