package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.StudentDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Student;
import com.gabrielpeixoto.studentapi.mapper.StudentMapper;
import com.gabrielpeixoto.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public MessageResponseDTO createStudent(StudentDTO student)
    {
        Student studentToSave = studentMapper.toModel(student);
        Student savedStudent = studentRepository.save(studentToSave);
        return MessageResponseDTO
                .builder().message("Created student with ID " + savedStudent.getId())
                .build();
    }
}
