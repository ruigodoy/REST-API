package com.example.demo.controller;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController{

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoDTO> getAlunos(){
        return alunoService.getAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Long id){
        return alunoService.getAlunoByIndex(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> criaAluno(@RequestBody AlunoDTO alunoDTO){
        return alunoService.criaAluno(alunoDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.ok().body(alunoService.atualizarAluno(id, alunoDTO));
    }

    @DeleteMapping(path={"/{id}"})
    public ResponseEntity<Optional<Object>> deletarAluno(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.deletarAluno(id));
    }

}
