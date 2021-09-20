package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.exception.DisciplinaNotFoundException;
import com.gabrielpeixoto.studentapi.mapper.DisciplinaMapper;
import com.gabrielpeixoto.studentapi.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    private final DisciplinaMapper disciplinaMapper = DisciplinaMapper.INSTANCE;

    public MessageResponseDTO createDisciplina(DisciplinaDTO disciplina)
    {
        Disciplina disciplinaToSave = disciplinaMapper.toModel(disciplina);
        Disciplina savedDisciplina = disciplinaRepository.save(disciplinaToSave);
        return createMessageResponse(savedDisciplina.getId(), "Created course with ID ");
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

    public MessageResponseDTO updateById(Long id, DisciplinaDTO disciplinaDTO) throws DisciplinaNotFoundException {
        verifyIfExists(id);

        Disciplina disciplinaToSave = disciplinaMapper.toModel(disciplinaDTO);
        Disciplina savedDisciplina = disciplinaRepository.save(disciplinaToSave);
        return createMessageResponse(savedDisciplina.getId(), "Updated course with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
