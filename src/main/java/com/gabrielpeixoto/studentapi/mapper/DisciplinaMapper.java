package com.gabrielpeixoto.studentapi.mapper;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    Disciplina toModel(DisciplinaDTO disciplinaDTO);

    DisciplinaDTO toDTO(Disciplina disciplina);
}
