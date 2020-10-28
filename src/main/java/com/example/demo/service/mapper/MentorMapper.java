package com.example.demo.service.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.model.Mentor;

public class MentorMapper {
    public static Mentor toMentor(MentorDTO mentorDTO) {
        Mentor mentor = new Mentor();

        mentor.setId(mentorDTO.getId());
        mentor.setName(mentorDTO.getName());
        mentor.setCity(mentorDTO.getCity());

        return mentor;
    }

    public static MentorDTO toMentorDTO(Mentor mentor){
        MentorDTO mentorDTO = new MentorDTO();

        mentorDTO.setId(mentor.getId());
        mentorDTO.setName(mentor.getName());
        mentorDTO.setCity(mentor.getCity());

        return mentorDTO;
    }
}
