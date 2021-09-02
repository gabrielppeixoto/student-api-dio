package com.gabrielpeixoto.studentapi.dto.request;

import com.gabrielpeixoto.studentapi.entity.Sala;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {
    private Long id;

    @NotBlank
    private String codigo;

    @NotBlank
    @Size(min = 10, max = 50)
    private String nome;

    @NotBlank
    @Size(min = 10, max = 50)
    private String professor;

    @Valid
    private SalaDTO sala;
}
