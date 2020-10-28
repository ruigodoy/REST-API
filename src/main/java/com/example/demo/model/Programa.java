package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Data

public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ano_inicio")
    private Integer anoInicio;

    @Column(name = "ano_fim")
    private Integer anoFim;
    private String descricao;
    private Integer active;

    public Programa(Long id, Integer anoInicio, Integer anoFim, String descricao) {
        this.id = id;
        this.anoInicio = anoInicio;
        this.anoFim = anoFim;
        this.descricao = descricao;
        this.active = 1;
    }

    public Programa(){
        this.active = 1;
    }
}
