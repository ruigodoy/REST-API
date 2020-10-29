package com.example.demo.service;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.model.Materia;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.service.mapper.MateriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MateriaService {
    @Autowired
    MateriaRepository materiaRepository;

    public List<Materia> getMateriaAtivas(){
        return materiaRepository.findByActive(1);
    }

    public List<Materia> getMateriaInativas(){
        return materiaRepository.findByActive(0);
    }

    public Optional<MateriaDTO> getMateriaByIndex(Long id) {
        return materiaRepository.findById(id).map(MateriaMapper::toMateriaDTO);
    }

    public Optional<MateriaDTO> criaMateria(MateriaDTO materiaDTO){
        if(materiaDTO != null){
            return Optional.of(MateriaMapper.toMateriaDTO(materiaRepository.save(MateriaMapper.toMateria(materiaDTO))));
        }else{
            return Optional.empty();
        }
    }

    public Optional<MateriaDTO> atualizarMateria(Long id, MateriaDTO materiaDTO){
        materiaDTO.setId(id);
        if(getMateriaByIndex(id).isPresent()){
            return Optional.of(MateriaMapper.toMateriaDTO(materiaRepository.save(MateriaMapper.toMateria(materiaDTO))));
        }else
            return Optional.empty();
    }

    public Optional<MateriaDTO> deletarMateria(Long id){
        Optional<Materia> materia = materiaRepository.findById(id);
        if(materia.isPresent()){
            materia.get().setActive(0);
            return Optional.of(MateriaMapper.toMateriaDTO(materiaRepository.save(materia.get())));
        }else{
            return Optional.empty();
        }
    }

    public Optional<MateriaDTO> ativarMateria(Long id){
        Optional<Materia> materia = materiaRepository.findById(id);
        if(materia.isPresent()){
            materia.get().setActive(1);
            return Optional.of(MateriaMapper.toMateriaDTO(materiaRepository.save(materia.get())));
        }else{
            return Optional.empty();
        }
    }
}
