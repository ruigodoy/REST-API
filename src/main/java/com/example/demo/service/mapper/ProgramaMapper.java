package com.example.demo.service.mapper;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.model.Programa;

public class ProgramaMapper {

    public static Programa toPrograma(ProgramaDTO programaDTO) {
        return new Programa(programaDTO.getId(),
                programaDTO.getAno_inicio(),
                programaDTO.getAno_fim(),
                programaDTO.getDescricao());
    }

    public static ProgramaDTO toProgramaDTO(Programa programa) {
        return new ProgramaDTO(programa.getId(),
                programa.getAno_inicio(),
                programa.getAno_fim(),
                programa.getDescricao());
    }
}
