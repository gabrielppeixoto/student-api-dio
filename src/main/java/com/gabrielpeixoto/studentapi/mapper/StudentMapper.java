package com.gabrielpeixoto.studentapi.mapper;

import com.gabrielpeixoto.studentapi.dto.request.StudentDTO;
import com.gabrielpeixoto.studentapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Student toModel(StudentDTO studentDTO);

    StudentDTO toDTO(Student Student);
}
