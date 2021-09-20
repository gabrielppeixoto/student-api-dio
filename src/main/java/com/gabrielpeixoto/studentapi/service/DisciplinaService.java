package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.exception.DisciplinaNotFoundException;
import com.gabrielpeixoto.studentapi.mapper.DisciplinaMapper;
import com.gabrielpeixoto.studentapi.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<DisciplinaDTO> findAll() {
        List<Disciplina> allDisciplina = disciplinaRepository.findAll();
        return allDisciplina.stream()
                .map(disciplinaMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Disciplina verifyIfExists(Long id) throws DisciplinaNotFoundException
    {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new DisciplinaNotFoundException(id));
    }

    public DisciplinaDTO findById(Long id) throws DisciplinaNotFoundException {
        Disciplina optionalDisciplina = verifyIfExists(id);
        return disciplinaMapper.toDTO(optionalDisciplina);
    }

    public void delete(Long id) throws DisciplinaNotFoundException{
        verifyIfExists(id);
        disciplinaRepository.deleteById(id);
    }
}
