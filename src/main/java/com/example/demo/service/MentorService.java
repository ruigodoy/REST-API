package com.example.demo.service;

import com.example.demo.dto.MentorDTO;
import com.example.demo.model.Mentor;
import com.example.demo.repository.MentorRepository;
import com.example.demo.service.mapper.MentorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MentorService {

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    MentoriaService mentoriaService;

    public List<Mentor> getMentoresAtivos(){
        return mentorRepository.findByActive(1);
    }

    public List<Mentor> getMentoresInativos(){
        return mentorRepository.findByActive(0);
    }

    public Optional<MentorDTO> getMentorByIndex(Long id) {
        return mentorRepository.findById(id).map(MentorMapper::toMentorDTO);
    }

    public Optional<MentorDTO> criaMentor(MentorDTO mentorDTO){
        if(mentorDTO != null){
            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(MentorMapper.toMentor(mentorDTO))));
        }else{
            return Optional.empty();
        }
    }

    public Optional<MentorDTO> atualizarMentor(Long id, MentorDTO mentorDTO){
        mentorDTO.setId(id);
        if(getMentorByIndex(id).isPresent()){
            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(MentorMapper.toMentor(mentorDTO))));
        }else
            return Optional.empty();
    }

    public Optional<MentorDTO> deletarMentor(Long id){
        Optional<Mentor> mentor = mentorRepository.findById(id);
        if(mentor.isPresent()){
            mentor.get().setActive(0);
            mentoriaService.setActiveMentor(0, id);
            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(mentor.get())));
        }else{
            return Optional.empty();
        }
    }

    public Optional<MentorDTO> ativarMentor(Long id){
        Optional<Mentor> mentor = mentorRepository.findById(id);
        if(mentor.isPresent()){
            mentor.get().setActive(1);
            mentoriaService.setActiveMentor(1, id);
            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(mentor.get())));
        }else{
            return Optional.empty();
        }
    }
}
