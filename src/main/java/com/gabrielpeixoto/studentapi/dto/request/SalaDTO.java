package com.gabrielpeixoto.studentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaDTO {
    private Long id;

    @NotEmpty
    private Integer numero;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String localizacao;

    @NotEmpty
    private Integer capacidade;
}
