package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MentorRepository mentorRepository;



    public List<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> getAlunoByIndex(Long id) {
        return alunoRepository.findById(id);
    }

    public AlunoDTO criaAluno(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setName(dto.getName());
        aluno.setClasse(dto.getClasse());

        Mentor mentor = mentorRepository.getOne(dto.getMentor_id());

        aluno.setMentor(mentor);
        alunoRepository.save(aluno);

        return dto;
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
