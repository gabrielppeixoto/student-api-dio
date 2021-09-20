package com.gabrielpeixoto.studentapi.utils;

import com.gabrielpeixoto.studentapi.dto.request.SalaDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;

public class SalaUtils {
    public static final Long SALA_ID = 1L;
    public static final Integer NUMERO = 23;
    public static final String LOCALIZACAO = "CT-2";
    public static final Integer CAPACIDADE = 45;

    public static SalaDTO createFakeDTO()
    {
        return SalaDTO.builder()
                .numero(NUMERO)
                .localizacao(LOCALIZACAO)
                .capacidade(CAPACIDADE)
                .build();
    }

    public static Sala createFakeEntity()
    {
        return Sala.builder()
                .id(SALA_ID)
                .numero(NUMERO)
                .localizacao(LOCALIZACAO)
                .capacidade(CAPACIDADE)
                .build();
    }
}
