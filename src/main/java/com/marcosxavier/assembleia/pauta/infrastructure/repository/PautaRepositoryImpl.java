package com.marcosxavier.assembleia.pauta.infrastructure.repository;

import com.marcosxavier.assembleia.pauta.domain.dtos.PautaResponseDTO;
import com.marcosxavier.assembleia.pauta.domain.entities.Pauta;
import com.marcosxavier.assembleia.pauta.infrastructure.persistence.PautaMongoDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaRepositoryImpl implements PautaRepository {

    private final PautaMongoDBRepository repository;

    @Override
    public Optional<Pauta> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<PautaResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(PautaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Pauta pauta) {
        repository.delete(pauta);
    }

    @Override
    public void save(Pauta pauta) {
        repository.save(pauta);
    }
}
