package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;
import com.gabrielpeixoto.studentapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
    private SalaRepository salaRepository;

    @Autowired
    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public MessageResponseDTO createSala(Sala sala)
    {
        Sala savedSala = salaRepository.save(sala);
        return MessageResponseDTO
                .builder()
                .message("Created room with ID " + savedSala.getId())
                .build();
    }
}
