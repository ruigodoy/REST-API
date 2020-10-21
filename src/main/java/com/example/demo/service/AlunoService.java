package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> getAlunoByIndex(Long id) {
        return alunoRepository.findById(id);
    }

    public void criaAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}
