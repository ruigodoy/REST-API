package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Data

public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private Integer active;

    public Mentor(){
        this.active = 1;
    }
}
