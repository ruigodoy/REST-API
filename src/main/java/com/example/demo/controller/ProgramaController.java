package com.example.demo.controller;

import com.example.demo.dto.ProgramaDTO;
import com.example.demo.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {
    @Autowired
    ProgramaService programaService;

    @GetMapping
    public List<ProgramaDTO> getProgramas(){
        return programaService.getPrograms();
    }

    @PostMapping
    public ResponseEntity<ProgramaDTO> criaPrograma(@RequestBody ProgramaDTO programaDTO){
        return programaService.criaPrograma(programaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
