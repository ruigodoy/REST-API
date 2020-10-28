package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgramaDTO {
    private Long id;
    private Integer anoInicio;
    private Integer anoFim;
    private String descricao;
}
