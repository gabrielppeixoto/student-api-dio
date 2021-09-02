package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.SalaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;
import com.gabrielpeixoto.studentapi.mapper.SalaMapper;
import com.gabrielpeixoto.studentapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
