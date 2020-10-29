package com.example.demo;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FirstMockTest {

    @Mock
    AlunoRepository alunoRepository;

    @InjectMocks
    AlunoService alunoService;

    @Test
    public void test(){
        var id = 1L;
        Mockito.when(alunoRepository.findById(id)).thenReturn(java.util.Optional.of(new Aluno("t", "t")));
        Optional<AlunoDTO> alunoDTO = this.alunoService.getAlunoByIndex(id);

        Assertions.assertTrue(alunoDTO.isPresent());
        AlunoDTO aluno = alunoDTO.get();
        Assertions.assertEquals("t", aluno.getName() );
        Assertions.assertEquals("t", aluno.getClasse());

    }
}
