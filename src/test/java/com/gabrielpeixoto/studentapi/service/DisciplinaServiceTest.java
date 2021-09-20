package com.gabrielpeixoto.studentapi.service;

import com.gabrielpeixoto.studentapi.dto.request.DisciplinaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Disciplina;
import com.gabrielpeixoto.studentapi.repository.DisciplinaRepository;
import com.gabrielpeixoto.studentapi.utils.DisciplinaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DisciplinaServiceTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @InjectMocks
    private DisciplinaService disciplinaService;

    @Test
    void testGivenDisciplinaDTOThenReturnSavedMessage()
    {
        DisciplinaDTO disciplinaDTO = DisciplinaUtils.createFakeDTO();
        Disciplina expectedSavedDisciplina = DisciplinaUtils.createFakeEntity();

        Mockito.when(disciplinaRepository.save(Mockito.any(Disciplina.class)))
                .thenReturn(expectedSavedDisciplina);

        MessageResponseDTO expectedSuccessMessage =
                createExpectedMessageResponse(expectedSavedDisciplina.getId());
        MessageResponseDTO successMessage = disciplinaService.createDisciplina(disciplinaDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id)
    {
        return MessageResponseDTO.builder()
                .message("Created course with ID " + id)
                .build();
    }
}
