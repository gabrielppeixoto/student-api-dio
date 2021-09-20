package com.gabrielpeixoto.studentapi.controller;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.exception.DisciplinaNotFoundException;
import com.gabrielpeixoto.studentapi.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplina")
public class DisciplinaController {
    private DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDisciplina(@RequestBody @Valid DisciplinaDTO disciplina)
    {
        return disciplinaService.createDisciplina(disciplina);
    }

    @GetMapping
    public List<DisciplinaDTO> listAll()
    {
        return disciplinaService.findAll();
    }

    @GetMapping("/{id}")
    public DisciplinaDTO findById(@PathVariable Long id) throws DisciplinaNotFoundException {
        return disciplinaService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws DisciplinaNotFoundException
    {
        disciplinaService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody DisciplinaDTO disciplinaDTO) throws DisciplinaNotFoundException {
        return disciplinaService.updateById(id, disciplinaDTO);
    }
}
