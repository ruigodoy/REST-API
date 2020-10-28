package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MentorDTO {
    private Long id;
    private String name;
    private String city;
    //private Integer active;
}
