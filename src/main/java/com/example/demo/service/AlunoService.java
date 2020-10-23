package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Programa;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.ProgramaRepository;
import com.example.demo.service.mapper.AlunoMapper;
import com.example.demo.service.mapper.ProgramaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ProgramaRepository programaRepository;

    @Autowired
    ProgramaService programaService;


    public List<AlunoDTO> getAlunos(){
        return alunoRepository.findAll().parallelStream().map(AlunoMapper::toAlunoDTO).collect(Collectors.toList());
    }

    public Optional<AlunoDTO> getAlunoByIndex(Long id) {
        return alunoRepository.findById(id).map(AlunoMapper::toAlunoDTO);
    }

    public Optional<AlunoDTO> criaAluno(AlunoDTO alunoDTO) {
        if(programaService.getProgramaByIndex(alunoDTO.getPrograma_id()).isPresent()){
            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(AlunoMapper.toAluno(alunoDTO))));
        }else{
            return Optional.empty();
        }
    }

    public AlunoDTO atualizarAluno(Long id, AlunoDTO alunoDTO){
        Aluno aluno = alunoRepository.findById(id).orElse(null);

        aluno.setName(alunoDTO.getName());
        aluno.setClasse(alunoDTO.getClasse());

        if(alunoDTO.getPrograma_id() != null){
            Programa programa = programaRepository.findById(alunoDTO.getPrograma_id()).orElse(null);
            aluno.setPrograma(programa);
        }else{
            aluno.setPrograma(null);
        }

        alunoDTO.setId(alunoRepository.save(aluno).getId());

        return alunoDTO;
    }

    public Optional<Object> deletarAluno(Long id){
        return alunoRepository.findById(id).map(alunoBack -> {
            alunoRepository.deleteById(id);
            return alunoBack;
        });
    }
}
