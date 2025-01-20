package com.marcosxavier.assembleia.voto.persistence.repository;

import com.marcosxavier.assembleia.voto.dtos.VotoResponseDTO;
import com.marcosxavier.assembleia.voto.entities.Voto;
import com.marcosxavier.assembleia.voto.persistence.databaseinterface.VotoMongoDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Log4j2
@RequiredArgsConstructor
public class VotoRepositoryImpl implements VotoRepository{

    private final VotoMongoDBRepository repository;

    @Override
    public Optional<Voto> buscaPorId(String id) {
        log.info("VotoRepositoryImpl - buscaPorId: {}", id);
        return repository.findById(id);
    }

    @Override
    public List<VotoResponseDTO> buscaLista() {
        log.info("VotoRepositoryImpl - buscaLista");
        return repository.findAll().stream()
                .map(VotoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleta(Voto voto) {
        log.info("VotoRepositoryImpl - deleta");
        repository.delete(voto);
    }

    @Override
    public void salva(Voto voto) {
        log.info("VotoRepositoryImpl - salva");
        repository.save(voto);
    }

    @Override
    public List<Voto> buscaTodasVotosPorIdPautaEIdEleitor(String idPauta, String idEleitor) {
        log.info("VotoRepositoryImpl - buscaTodasVotosPorIdPautaEIdEleitor: {} e {}", idPauta, idEleitor);
        return repository.findByIdPautaAndIdEleitor(idPauta,idEleitor);
    }

    @Override
    public void zeraCollectionVoto() {
        log.info("VotoRepositoryImpl - zeraCollectionEleitor");
        repository.deleteAll();
    }

    @Override
    public Long contaVotosPorPautaAprovacao(String idPauta, String aprovacao) {
        log.info("VotoRepositoryImpl - contaVotosPorPautaAprovacao: {} e {}", idPauta, aprovacao);
        return repository.countByIdPautaAndAprovacao(idPauta, aprovacao);
    }
}
