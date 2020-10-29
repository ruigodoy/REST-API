package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Data

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programa_id")
    private Programa programa;

    private String name;
    private String classe;

    private Integer active;

    public Aluno(){
        this.active = 1;
    }
    public Aluno(String name, String classe){
        this.name = name;
        this.classe = classe;
    }

}
