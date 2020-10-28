package com.example.demo.service.mapper;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.model.Programa;

public class ProgramaMapper {

    public static Programa toPrograma(ProgramaDTO programaDTO) {
        return new Programa(programaDTO.getId(),
                programaDTO.getAnoInicio(),
                programaDTO.getAnoFim(),
                programaDTO.getDescricao());
    }

    public static ProgramaDTO toProgramaDTO(Programa programa) {
        return new ProgramaDTO(programa.getId(),
                programa.getAnoInicio(),
                programa.getAnoFim(),
                programa.getDescricao());
    }
}
