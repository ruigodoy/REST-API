package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgramaDTO {
    private Long id;
    private Integer ano_inicio;
    private Integer ano_fim;
    private String descricao;
}
