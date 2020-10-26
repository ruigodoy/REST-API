package com.example.demo.service.mapper;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Programa;

public class AlunoMapper {

    public static Aluno toAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        aluno.setId(alunoDTO.getId());
        aluno.setClasse(alunoDTO.getClasse());
        aluno.setName(alunoDTO.getName());
        aluno.setActive(alunoDTO.getActive());
        if (alunoDTO.getPrograma_id() != null) {
            Programa programa = new Programa();
            programa.setId(alunoDTO.getPrograma_id());
            aluno.setPrograma(programa);
        } else
            aluno.setPrograma(null);

        return aluno;
    }

    public static AlunoDTO toAlunoDTO(Aluno aluno) {

        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setClasse(aluno.getClasse());
        alunoDTO.setName(aluno.getName());
        alunoDTO.setId(aluno.getId());
        alunoDTO.setActive(aluno.getActive());
        if (aluno.getPrograma() != null) {
            alunoDTO.setPrograma_id(aluno.getPrograma().getId());
        } else
            alunoDTO.setPrograma_id(null);

        return alunoDTO;
    }
}
