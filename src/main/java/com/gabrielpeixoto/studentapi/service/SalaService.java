package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.SalaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;
import com.gabrielpeixoto.studentapi.entity.Student;
import com.gabrielpeixoto.studentapi.exception.SalaNotFoundException;
import com.gabrielpeixoto.studentapi.exception.StudentNotFoundException;
import com.gabrielpeixoto.studentapi.mapper.SalaMapper;
import com.gabrielpeixoto.studentapi.repository.SalaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalaService {
    private SalaRepository salaRepository;

    private final SalaMapper salaMapper = SalaMapper.INSTANCE;

    public MessageResponseDTO createSala(SalaDTO sala)
    {
        Sala salaToSave = salaMapper.toModel(sala);
        Sala savedSala = salaRepository.save(salaToSave);
        return createMessageResponse(savedSala.getId(), "Created room with ID ");
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

    public MessageResponseDTO updateById(Long id, SalaDTO salaDTO) throws SalaNotFoundException {
        verifyIfExists(id);

        Sala salaToSave = salaMapper.toModel(salaDTO);
        Sala savedSala = salaRepository.save(salaToSave);
        return createMessageResponse(savedSala.getId(), "Updated room with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}
