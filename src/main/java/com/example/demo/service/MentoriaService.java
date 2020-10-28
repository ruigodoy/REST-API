package com.example.demo.service;

import com.example.demo.dto.MentoriaDTO;
import com.example.demo.model.Mentoria;
import com.example.demo.repository.MentoriaRepository;
import com.example.demo.service.mapper.MentoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    MentorService mentorService;

    @Autowired
    AlunoService alunoService;

    public List<Mentoria> getMentoriasAtivas() {
        return mentoriaRepository.findByActive(1);
    }

    public List<Mentoria> getMentoriasInativas(){
        return mentoriaRepository.findByActive(0);
    }

    public Optional<MentoriaDTO> getMentoriaByIndex(Long id){
        return mentoriaRepository.findById(id).map(MentoriaMapper::toMentoriaDTO);
    }

    public Optional<MentoriaDTO> criarMentoria(MentoriaDTO mentoriaDTO) {
        if (alunoService.getAlunoByIndex(mentoriaDTO.getAlunoId()).isPresent() && mentorService.getMentorByIndex(mentoriaDTO.getMentorId()).isPresent()) {
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(MentoriaMapper.toMentoria(mentoriaDTO))));
        }else{
            return Optional.empty();
        }
    }

    public Optional<MentoriaDTO> atualizarMentoria(Long id, MentoriaDTO mentoriaDTO){
        mentoriaDTO.setId(id);
        //if(alunoService.getAlunoByIndex(id).isPresent()  && mentorService.getMentorByIndex(mentoriaDTO.getMentorId()).isPresent()){
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(MentoriaMapper.toMentoria(mentoriaDTO))));
        //}else
            //return Optional.empty();
    }

    public Optional<MentoriaDTO> deletarMentoria(Long id){
        Optional<Mentoria> mentoria = mentoriaRepository.findById(id);
        if(mentoria.isPresent()){
            mentoria.get().setActive(0);
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(mentoria.get())));
        }else{
            return Optional.empty();
        }
    }

    public Optional<MentoriaDTO> ativarMentoria(Long id){
        Optional<Mentoria> mentoria = mentoriaRepository.findById(id);
        if(mentoria.isPresent()){
            mentoria.get().setActive(1);
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(mentoria.get())));
        }else{
            return Optional.empty();
        }
    }

    public void setActiveAluno(Integer active, Long id) {
        mentoriaRepository.setActiveByAlunoId(active, id);
    }

    public void setActiveMentor(Integer active, Long id) {
        mentoriaRepository.setActiveByMentorId(active, id);
    }

}
