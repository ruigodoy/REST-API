package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.mapper.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ProgramaService programaService;

    @Autowired
    MentoriaService mentoriaService;

    public List<Aluno> getActives() {
        return alunoRepository.findByActive(1);
    }

    public List<Aluno> getAlunosInativos() {
        return alunoRepository.findByActive(0);
    }

    public Optional<AlunoDTO> getAlunoByIndex(Long id) {
        return alunoRepository.findById(id).map(AlunoMapper::toAlunoDTO);
    }

    public Optional<AlunoDTO> criaAluno(AlunoDTO alunoDTO) {
        if (programaService.getProgramaByIndex(alunoDTO.getPrograma_id()).isPresent() || alunoDTO.getPrograma_id() == null) {
            //alunoDTO.setActive(1);
            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(AlunoMapper.toAluno(alunoDTO))));
        } else {
            return Optional.empty();
        }
    }

    public Optional<AlunoDTO> atualizarAluno(Long id, AlunoDTO alunoDTO) {
        alunoDTO.setId(id);

        if (getAlunoByIndex(id).isPresent() && (programaService.getProgramaByIndex(alunoDTO.getPrograma_id()).isPresent() || alunoDTO.getPrograma_id() == null)) {
            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(AlunoMapper.toAluno(alunoDTO))));
        } else {
            return Optional.empty();
        }
    }

    public Optional<AlunoDTO> deletarAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            aluno.get().setActive(0);
            mentoriaService.setActiveAluno(0, id);
            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(aluno.get())));
        } else {
            return Optional.empty();
        }
    }

    public Optional<AlunoDTO> ativarAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            aluno.get().setActive(1);
            mentoriaService.setActiveAluno(1, id);
            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(aluno.get())));
        } else {
            return Optional.empty();
        }
    }
}
