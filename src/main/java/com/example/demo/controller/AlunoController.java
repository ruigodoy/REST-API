package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAlunos(){
        return alunoService.getAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>> getAluno(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.getAlunoByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> criaAluno(@RequestBody Aluno aluno){
        alunoService.criaAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Optional<Aluno>> atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){
        return ResponseEntity.ok().body(alunoService.atualizarAluno(id, aluno));
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<Optional<Object>> deletarAluno(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.deletarAluno(id));
    }

}
