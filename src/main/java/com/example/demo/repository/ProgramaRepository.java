package com.example.demo.repository;

import com.example.demo.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {
    List<Programa> findByActive(Integer active);
}
