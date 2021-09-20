package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.SalaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;
import com.gabrielpeixoto.studentapi.entity.Student;
import com.gabrielpeixoto.studentapi.exception.SalaNotFoundException;
import com.gabrielpeixoto.studentapi.exception.StudentNotFoundException;
import com.gabrielpeixoto.studentapi.mapper.SalaMapper;
import com.gabrielpeixoto.studentapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaService {
    private SalaRepository salaRepository;

    private final SalaMapper salaMapper = SalaMapper.INSTANCE;

    @Autowired
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public MessageResponseDTO createSala(SalaDTO sala)
    {
        Sala salaToSave = salaMapper.toModel(sala);
        Sala savedSala = salaRepository.save(salaToSave);
        return MessageResponseDTO
                .builder()
                .message("Created room with ID " + savedSala.getId())
                .build();
    }

    public List<SalaDTO> listAll() {
        List<Sala> allSala = salaRepository.findAll();
        return allSala.stream()
                .map(salaMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Sala verifyIfExists(Long id) throws SalaNotFoundException {
        return salaRepository.findById(id)
                .orElseThrow(() -> new SalaNotFoundException(id));
    }

    public SalaDTO findById(Long id) throws SalaNotFoundException {
        Sala optionalSala = verifyIfExists(id);
        return salaMapper.toDTO(optionalSala);
    }

    public void delete(Long id) throws SalaNotFoundException
    {
        verifyIfExists(id);
        salaRepository.deleteById(id);
    }
}
