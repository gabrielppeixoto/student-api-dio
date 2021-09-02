package com.gabrielpeixoto.studentapi.dto.request;

import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String nome;
    private LocalDate dataNascimento;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String matricula;

    @Valid
    @NotEmpty
    private EnderecoDTO endereco;

    @NotEmpty
    private String cpf;

    @NotEmpty
    @Size(min = 5, max = 40)
    private String email;

    @Valid
    private List<DisciplinaDTO> disciplinasMatriculadas;
}
