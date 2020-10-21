package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List getAlunos(){
        return alunoService.getAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAluno(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.getAlunoByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> criaAluno(@RequestBody Aluno aluno){
        alunoService.criaAluno(aluno);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){

        return ResponseEntity.ok().body(alunoService.atualizarAluno(id, aluno));
    }
}
