package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mes_id")
    private Mes mes;

    private Integer nota;
    private Integer active;
}
