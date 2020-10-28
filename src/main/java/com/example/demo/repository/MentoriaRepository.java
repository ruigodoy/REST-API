package com.example.demo.repository;

import com.example.demo.model.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {
    List<Mentoria> findByActive(Integer active);

    @Modifying
    @Query(value = "update mentoria set active = ?1 where aluno_id in (select id from aluno where id = ?2)", nativeQuery = true)
    void setActiveByAlunoId(Integer active, Long id);

    @Modifying
    @Query(value = "update mentoria set active = ?1 where mentor_id in (select id from mentor where id = ?2)", nativeQuery = true)
    void setActiveByMentorId(Integer active, Long id);
}
