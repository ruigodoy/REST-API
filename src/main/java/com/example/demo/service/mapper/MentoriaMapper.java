package com.example.demo.service.mapper;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.model.Mentoria;

public class MentoriaMapper {

    public static Mentoria toMentoria(MentoriaDTO mentoriaDTO){
        Mentoria mentoria = new Mentoria();
        Aluno aluno = new Aluno();
        Mentor mentor = new Mentor();

        aluno.setId(mentoriaDTO.getAlunoId());
        mentor.setId(mentoriaDTO.getMentorId());

        mentoria.setId(mentoriaDTO.getId());
        mentoria.setAluno(aluno);
        mentoria.setMentor(mentor);

        return mentoria;
    }

    public static MentoriaDTO toMentoriaDTO(Mentoria mentoria){
        MentoriaDTO mentoriaDTO = new MentoriaDTO();

        mentoriaDTO.setId(mentoria.getId());
        mentoriaDTO.setAlunoId(mentoria.getAluno().getId());
        mentoriaDTO.setMentorId(mentoria.getMentor().getId());

        return mentoriaDTO;
    }
}
