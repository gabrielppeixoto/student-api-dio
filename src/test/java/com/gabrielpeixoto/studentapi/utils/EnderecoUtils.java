package com.gabrielpeixoto.studentapi.utils;

import com.gabrielpeixoto.studentapi.dto.request.EnderecoDTO;
import com.gabrielpeixoto.studentapi.entity.Endereco;

public class EnderecoUtils {
    public static final Long ENDERECO_ID = 1L;
    public static final String TIPO = "Avenida";
    public static final String NOME = "Coronel Manoel Nunes";
    public static final Integer NUMERO = 1234;
    public static final String BAIRRO = "Tropical";
    public static final String CIDADE = "Serra";
    public static final String ESTADO = "ES";
    public static final String PAIS = "Brasil";

    public static EnderecoDTO createFakeDTO()
    {
        return EnderecoDTO.builder()
                .tipo(TIPO)
                .nome(NOME)
                .numero(NUMERO)
                .bairro(BAIRRO)
                .cidade(CIDADE)
                .estado(ESTADO)
                .pais(PAIS)
                .build();
    }

    public static Endereco createFakeEntity()
    {
        return Endereco.builder()
                .id(ENDERECO_ID)
                .tipo(TIPO)
                .nome(NOME)
                .numero(NUMERO)
                .bairro(BAIRRO)
                .cidade(CIDADE)
                .estado(ESTADO)
                .pais(PAIS)
                .build();
    }
}
