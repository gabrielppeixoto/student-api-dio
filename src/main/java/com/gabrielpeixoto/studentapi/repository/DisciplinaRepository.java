package com.gabrielpeixoto.studentapi.repository;

import com.gabrielpeixoto.studentapi.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
