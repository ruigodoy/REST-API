package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.MentorDTO;
import com.example.demo.dto.MentoriaDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.model.Mentoria;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.MentoriaRepository;
import com.example.demo.service.mapper.AlunoMapper;
import com.example.demo.service.mapper.MentoriaMapper;
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
    MentorService mentorService;

    @Autowired
    AlunoService alunoService;

    public List<Mentoria> getMentorias() {
        return mentoriaRepository.findAll();
    }

    public Optional<MentoriaDTO> criarMentoria(MentoriaDTO mentoriaDTO) {
        if (alunoService.getAlunoByIndex(mentoriaDTO.getAluno_id()).isPresent() && mentorService.getMentorByIndex(mentoriaDTO.getMentor_id()).isPresent()) {
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(MentoriaMapper.toMentoria(mentoriaDTO))));
        }else{
            return Optional.empty();
        }
    }

    public void setActiveAluno(Integer active, Long id) {
        mentoriaRepository.setActiveByAlunoId(active, id);
    }

    public void setActiveMentor(Integer active, Long id) {
        mentoriaRepository.setActiveByMentorId(active, id);
    }

}
