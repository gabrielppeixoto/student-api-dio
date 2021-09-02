package com.gabrielpeixoto.studentapi.mapper;

import com.gabrielpeixoto.studentapi.dto.request.EnderecoDTO;
import com.gabrielpeixoto.studentapi.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    Endereco toModel(EnderecoDTO enderecoDTO);

    EnderecoDTO toDTO(Endereco endereco);
}
