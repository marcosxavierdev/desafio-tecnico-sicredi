package com.marcosxavier.assembleia.pauta.persistence.repository;

import com.marcosxavier.assembleia.pauta.domain.dtos.PautaResponseDTO;
import com.marcosxavier.assembleia.pauta.domain.entities.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaRepository {

    Optional<Pauta> buscaPorId(String id);
    List<PautaResponseDTO> buscaLista();
    void deleta(Pauta pauta);
    void salva(Pauta pauta);
    void zeraCollectionPauta();
}
