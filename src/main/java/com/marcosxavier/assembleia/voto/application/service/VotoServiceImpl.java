package com.marcosxavier.assembleia.voto.application.service;

import com.marcosxavier.assembleia.voto.assembler.VotoAssembler;
import com.marcosxavier.assembleia.voto.domain.dtos.VotoRequestDTO;
import com.marcosxavier.assembleia.voto.domain.dtos.VotoResponseDTO;
import com.marcosxavier.assembleia.voto.domain.dtos.VotoUpdateDTO;
import com.marcosxavier.assembleia.voto.domain.entities.Voto;
import com.marcosxavier.assembleia.voto.persistence.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository repository;

    public Voto buscaVotoPorId(String id) {
        return repository.buscaPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Voto não encontrado!"));
    }

    @Override
    public VotoResponseDTO buscaPorId(String id) {
        var voto = buscaVotoPorId(id);
        var votoMapper= new VotoAssembler();
        return votoMapper.toResponseDTO(voto);
    }

    @Override
    public VotoResponseDTO criaVoto(VotoRequestDTO request) {
        var voto = new Voto(request);
        repository.salva(voto);
        return new VotoResponseDTO(voto);
    }

    @Override
    public VotoResponseDTO atualizaVoto(VotoUpdateDTO update) {
        Voto voto = buscaVotoPorId(update.getId());
        if (update.getIdPauta() != null) {
            voto.setIdPauta(update.getIdPauta());
        }
        if (update.getIdEleitor() != null) {
            voto.setIdEleitor(update.getIdEleitor());
        }
        if (update.getAprovacao() != null) {
            voto.setAprovacao(update.getAprovacao());
        }
        repository.salva(voto);
        return new VotoResponseDTO(voto);
    }

    @Override
    public List<VotoResponseDTO> buscaTodosVotos() {
        return repository.buscaLista();
    }

    @Override
    public void deletaVoto(String id) {
        Voto voto = buscaVotoPorId(id);
        repository.deleta(voto);
    }
}
