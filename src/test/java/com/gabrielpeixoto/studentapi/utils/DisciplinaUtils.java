package com.gabrielpeixoto.studentapi.utils;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;

public class DisciplinaUtils {
    public static final Long DISCIPLINA_ID = 1L;
    public static final String CODIGO = "CC01234";
    public static final String NOME = "ED2";
    public static final String PROFESSOR = "Ana Maria";

    public static DisciplinaDTO createFakeDTO()
    {
        return DisciplinaDTO.builder()
                .codigo(CODIGO)
                .nome(NOME)
                .professor(PROFESSOR)
                .sala(SalaUtils.createFakeDTO())
                .build();
    }

    public static Disciplina createFakeEntity()
    {
        return Disciplina.builder()
                .id(DISCIPLINA_ID)
                .codigo(CODIGO)
                .nome(NOME)
                .professor(PROFESSOR)
                .sala(SalaUtils.createFakeEntity())
                .build();
    }
}
