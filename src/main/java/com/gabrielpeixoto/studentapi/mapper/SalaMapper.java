package com.gabrielpeixoto.studentapi.mapper;

import com.gabrielpeixoto.studentapi.dto.request.SalaDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalaMapper {
    SalaMapper INSTANCE = Mappers.getMapper(SalaMapper.class);

    Sala toModel(SalaDTO salaDTO);

    SalaDTO toDTO(Sala sala);
}
