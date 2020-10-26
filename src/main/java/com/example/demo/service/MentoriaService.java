package com.example.demo.service;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.model.Mentoria;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    AlunoRepository alunoRepository;

    public List<Mentoria> getMentorias() {
        return mentoriaRepository.findAll();
    }

    public Optional<MentoriaDTO> criarMentoria(MentoriaDTO mentoriaDTO) {
        /*Mentoria mentoria = new Mentoria();

        Mentor mentor = mentorRepository.findById(dto.getMentor_id()).orElse(null);
        Aluno aluno = alunoRepository.findById(dto.getAluno_id()).orElse(null);

        mentoria.setMentor(mentor);
        mentoria.setAluno(aluno);

        mentoriaRepository.save(mentoria);

        return dto;*/


        return null;
    }

    public void setActiveAluno(Integer active, Long id) {
        mentoriaRepository.setActiveByAlunoId(active, id);
    }

    public void setActiveMentor(Integer active, Long id){
        mentoriaRepository.setActiveByMentorId(active, id);
    }

}
