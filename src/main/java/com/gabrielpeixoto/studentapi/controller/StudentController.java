package com.gabrielpeixoto.studentapi.controller;

import com.gabrielpeixoto.studentapi.dto.request.StudentDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Student;
import com.gabrielpeixoto.studentapi.exception.StudentNotFoundException;
import com.gabrielpeixoto.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createStudent(@RequestBody @Valid StudentDTO student)
    {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<StudentDTO> listAll()
    {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws StudentNotFoundException {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) throws StudentNotFoundException {
        return studentService.updateById(id, studentDTO);
    }
}
