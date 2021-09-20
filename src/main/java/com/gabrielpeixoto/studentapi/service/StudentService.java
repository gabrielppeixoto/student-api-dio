package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.StudentDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Student;
import com.gabrielpeixoto.studentapi.exception.StudentNotFoundException;
import com.gabrielpeixoto.studentapi.mapper.StudentMapper;
import com.gabrielpeixoto.studentapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {
    private StudentRepository studentRepository;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    public MessageResponseDTO createStudent(StudentDTO student)
    {
        Student studentToSave = studentMapper.toModel(student);
        Student savedStudent = studentRepository.save(studentToSave);
        return createMessageResponse(savedStudent.getId(), "Created student with ID ");
    }

    public List<StudentDTO> findAll() {
        List<Student> allStudent = studentRepository.findAll();
        return allStudent.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Student verifyIfExists(Long id) throws StudentNotFoundException
    {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public StudentDTO findById(Long id) throws StudentNotFoundException {
        Student optionalStudent = verifyIfExists(id);
        return studentMapper.toDTO(optionalStudent);
    }

    public void delete(Long id) throws StudentNotFoundException {
        verifyIfExists(id);
        studentRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, StudentDTO studentDTO) throws StudentNotFoundException {
        verifyIfExists(id);

        Student studentToSave = studentMapper.toModel(studentDTO);
        Student savedStudent = studentRepository.save(studentToSave);
        return createMessageResponse(savedStudent.getId(), "Updated student with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder().message(s + id)
                .build();
    }
}
