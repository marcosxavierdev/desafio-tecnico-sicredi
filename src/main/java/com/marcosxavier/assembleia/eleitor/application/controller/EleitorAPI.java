package com.marcosxavier.assembleia.eleitor.application.controller;

import com.marcosxavier.assembleia.eleitor.domain.dtos.EleitorRequestDTO;
import com.marcosxavier.assembleia.eleitor.domain.dtos.EleitorResponseDTO;
import com.marcosxavier.assembleia.eleitor.domain.dtos.EleitorUpdateDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/public/v1/eleitor")
public interface EleitorAPI {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    EleitorResponseDTO buscaPorId(@PathVariable String id);

    @GetMapping(value = "/byCPF/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    EleitorResponseDTO buscaPorCpf(@PathVariable String cpf);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EleitorResponseDTO criaEleitor (@Valid @RequestBody EleitorRequestDTO request);

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    EleitorResponseDTO atualizaEleitor(@Valid @RequestBody EleitorUpdateDTO update);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EleitorResponseDTO> buscaTodosEleitores();

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaEleitor (@PathVariable String id);
}
