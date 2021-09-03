package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.StudentDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Student;
import com.gabrielpeixoto.studentapi.exception.StudentNotFoundException;
import com.gabrielpeixoto.studentapi.mapper.StudentMapper;
import com.gabrielpeixoto.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<StudentDTO> findAll() {
        List<Student> allStudent = studentRepository.findAll();
        return allStudent.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO findById(Long id) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty())
        {
            throw new StudentNotFoundException(id);
        }
        return studentMapper.toDTO(optionalStudent.get());
    }
}
