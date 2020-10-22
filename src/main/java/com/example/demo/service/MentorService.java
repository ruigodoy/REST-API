package com.example.demo.service;

import com.example.demo.model.Mentor;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    MentorRepository mentorRepository;

    public List<Mentor> getMentores(){
        return mentorRepository.findAll();
    }

    public void criaMentor(Mentor mentor){
        mentorRepository.save(mentor);
    }

    public Optional<Mentor> atualizarMentor(Long id, Mentor mentor){
        return mentorRepository.findById(id).map(mentorBack -> {
            mentorBack.setName(mentor.getName());
            mentorBack.setCity(mentor.getCity());
            return mentorRepository.save(mentorBack);
        });
    }

    public Optional<Object> deletarMentor(Long id){
        return mentorRepository.findById(id).map(mentorDelete -> {
            mentorRepository.deleteById(id);
            return mentorDelete;
        });
    }
}
