package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlunoDTO {
    private Long id;
    private Long programa_id;
    private String name;
    private String classe;
    //private Integer active;
}
