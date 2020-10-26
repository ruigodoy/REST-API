package com.example.demo.controller;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAlunos() {
        return alunoService.getActives();
    }

    @GetMapping("/inativos")
    public List<Aluno> getAlunosInativos() {
        return alunoService.getAlunosInativos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Long id) {
        return alunoService.getAlunoByIndex(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> criaAluno(@RequestBody AlunoDTO alunoDTO) {
        return alunoService.criaAluno(alunoDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        return alunoService.atualizarAluno(id, alunoDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/ativar/{id}")
    public ResponseEntity<AlunoDTO> ativarAluno(@PathVariable("id") Long id) {
        return alunoService.ativarAluno(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<AlunoDTO> deletarAluno(@PathVariable Long id) {
        return alunoService.deletarAluno(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
