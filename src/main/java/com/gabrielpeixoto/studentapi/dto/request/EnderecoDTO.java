package com.gabrielpeixoto.studentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Long id;

    @NotEmpty
    private String tipo;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String nome;

    private Integer numero;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String bairro;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String cidade;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String estado;

    @NotEmpty
    private String pais;
}
