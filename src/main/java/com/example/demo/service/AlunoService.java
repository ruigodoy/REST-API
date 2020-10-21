package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Aluno> atualizarAluno(Long id, Aluno aluno){
        return alunoRepository.findById(id).map(alunoBack -> {
            alunoBack.setName(aluno.getName());
            alunoBack.setClasse(aluno.getClasse());
            return alunoRepository.save(alunoBack);
        });
    }

    public Optional<Object> deletarAluno(Long id){
        return alunoRepository.findById(id).map(alunoBack -> {
            alunoRepository.deleteById(id);
            return alunoBack;
        });
    }
}
