package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public MessageResponseDTO createDisciplina(Disciplina disciplina)
    {
        Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
        return MessageResponseDTO.builder()
                .message("Created course with ID " + savedDisciplina.getId())
                .build();
    }
}
