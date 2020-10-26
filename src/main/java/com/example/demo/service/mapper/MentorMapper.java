package com.example.demo.service.mapper;

import com.example.demo.dto.MentorDTO;
import com.example.demo.model.Mentor;

public class MentorMapper {
    public static Mentor toMentor(MentorDTO mentorDTO) {
        return new Mentor(mentorDTO.getId(), mentorDTO.getName(), mentorDTO.getCity());
    }

    public static MentorDTO toMentorDTO(Mentor mentor){
        return new MentorDTO(mentor.getId(), mentor.getName(), mentor.getCity());
    }
}
