package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.mapper.DisciplinaMapper;
import com.gabrielpeixoto.studentapi.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    private final DisciplinaMapper disciplinaMapper = DisciplinaMapper.INSTANCE;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public MessageResponseDTO createDisciplina(DisciplinaDTO disciplina)
    {
        Disciplina disciplinaToSave = disciplinaMapper.toModel(disciplina);
        Disciplina savedDisciplina = disciplinaRepository.save(disciplinaToSave);
        return MessageResponseDTO.builder()
                .message("Created course with ID " + savedDisciplina.getId())
                .build();
    }
}
