package com.example.demo.service;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.repository.ProgramaRepository;
import com.example.demo.service.mapper.ProgramaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramaService {

    @Autowired
    ProgramaRepository programaRepository;

    public Optional<ProgramaDTO> getProgramaByIndex(Long id){
        return programaRepository.findById(id).map(ProgramaMapper::toProgramaDTO);
    }

    public List<ProgramaDTO> getPrograms(){
        return programaRepository.findAll()
                                 .parallelStream()
                                 .map(ProgramaMapper::toProgramaDTO)
                                 .collect(Collectors.toList());
    }


    public ProgramaDTO criaPrograma(ProgramaDTO programaDTO){
        return ProgramaMapper.toProgramaDTO(programaRepository.save(ProgramaMapper.toPrograma(programaDTO)));
    }
}