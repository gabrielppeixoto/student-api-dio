package com.gabrielpeixoto.studentapi.repository;

import com.gabrielpeixoto.studentapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
