package com.gabrielpeixoto.studentapi.controller;

import com.gabrielpeixoto.studentapi.dto.request.SalaDTO;
import com.gabrielpeixoto.studentapi.dto.response.MessageResponseDTO;
import com.gabrielpeixoto.studentapi.entity.Sala;
import com.gabrielpeixoto.studentapi.exception.SalaNotFoundException;
import com.gabrielpeixoto.studentapi.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ap1/v1/sala")
public class SalaController {
    private SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createSala(@RequestBody @Valid SalaDTO sala)
    {
        return salaService.createSala(sala);
    }

    @GetMapping
    public List<SalaDTO> listAll()
    {
        return salaService.listAll();
    }

    @GetMapping("/{id}")
    public SalaDTO findById(@PathVariable Long id) throws SalaNotFoundException {
        return salaService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws SalaNotFoundException
    {
        salaService.delete(id);
    }
}
