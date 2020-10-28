package com.example.demo.service;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.model.Programa;
import com.example.demo.repository.ProgramaRepository;
import com.example.demo.service.mapper.ProgramaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProgramaService {

    @Autowired
    ProgramaRepository programaRepository;

    @Autowired
    AlunoService alunoService;

    public List<Programa> getProgramasAtivos(){
        return programaRepository.findByActive(1);
    }

    public List<Programa> getProgramasInativos(){
        return programaRepository.findByActive(0);
    }

    public Optional<ProgramaDTO> getProgramaByIndex(Long id) {
        return programaRepository.findById(id).map(ProgramaMapper::toProgramaDTO);
    }

    public Optional<ProgramaDTO> criaPrograma(ProgramaDTO programaDTO){
        if(programaDTO != null){
            return Optional.of(ProgramaMapper.toProgramaDTO(programaRepository.save(ProgramaMapper.toPrograma(programaDTO))));
        }else{
            return Optional.empty();
        }
    }

    public Optional<ProgramaDTO> atualizarPrograma(Long id, ProgramaDTO programaDTO){
        programaDTO.setId(id);
        if(getProgramaByIndex(id).isPresent()){
            return Optional.of(ProgramaMapper.toProgramaDTO(programaRepository.save(ProgramaMapper.toPrograma(programaDTO))));
        }else
            return Optional.empty();
    }

    public Optional<ProgramaDTO> deletarPrograma(Long id){
        Optional<Programa> programa = programaRepository.findById(id);
        if(programa.isPresent()){
            programa.get().setActive(0);
            alunoService.setProgramaNull(id);
            return Optional.of(ProgramaMapper.toProgramaDTO(programaRepository.save(programa.get())));
        }else{
            return Optional.empty();
        }
    }

    public Optional<ProgramaDTO> ativarPrograma(Long id){
        Optional<Programa> programa = programaRepository.findById(id);
        if(programa.isPresent()){
            programa.get().setActive(1);
            return Optional.of(ProgramaMapper.toProgramaDTO(programaRepository.save(programa.get())));
        }else{
            return Optional.empty();
        }
    }
}
