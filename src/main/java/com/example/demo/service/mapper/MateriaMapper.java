package com.example.demo.service.mapper;

import com.example.demo.dto.MateriaDTO;
import com.example.demo.model.Materia;

public class MateriaMapper {
    public static Materia toMateria(MateriaDTO materiaDTO) {
        return new Materia(materiaDTO.getId(), materiaDTO.getNome());

    }

    public static MateriaDTO toMateriaDTO(Materia materia) {
        return new MateriaDTO(materia.getId(), materia.getNome());
    }
}
