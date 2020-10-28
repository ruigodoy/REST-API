package com.example.demo.repository;

import com.example.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByActive(Integer active);

    @Modifying
    @Query(value = "update aluno set programa_id = null where programa_id in (select id from programa where id = ?1)", nativeQuery = true)
    void setProgramaNullAluno(Long id);
}