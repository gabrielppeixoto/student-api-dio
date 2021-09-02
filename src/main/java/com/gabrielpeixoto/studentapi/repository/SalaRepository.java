package com.gabrielpeixoto.studentapi.repository;

import com.gabrielpeixoto.studentapi.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}
