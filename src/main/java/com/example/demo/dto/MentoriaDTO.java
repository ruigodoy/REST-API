package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MentoriaDTO {
    private Long id;
    private Long mentorId;
    private Long alunoId;

/*    private Long mentor_id;
    private Long aluno_id;*/
}
