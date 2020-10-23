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

import java.util.ArrayList;
import java.util.List;

@Service
public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    AlunoRepository alunoRepository;

    public List<MentoriaDTO> getMentorias(){
        List<Mentoria> all = mentoriaRepository.findAll();
        List<MentoriaDTO> mentoriaDTOS = new ArrayList<>();

        all.forEach(mentoria -> {
            MentoriaDTO mentoriaDTO = new MentoriaDTO();
            mentoriaDTO.setMentor_id(mentoria.getMentor().getId());
            mentoriaDTO.setAluno_id(mentoria.getAluno().getId());
            mentoriaDTOS.add(mentoriaDTO);
        });

        return mentoriaDTOS;
    }

    public MentoriaDTO criarMentoria(MentoriaDTO dto) {
        Mentoria mentoria = new Mentoria();

        Mentor mentor = mentorRepository.findById(dto.getMentor_id()).orElse(null);
        Aluno aluno = alunoRepository.findById(dto.getAluno_id()).orElse(null);

        mentoria.setMentor(mentor);
        mentoria.setAluno(aluno);

        mentoriaRepository.save(mentoria);

        return dto;
    }

}
