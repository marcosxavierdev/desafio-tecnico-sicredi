package com.marcosxavier.assembleia.voto.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotoUpdateDTO {
    @NotEmpty(message = "O campo id não pode ser nulo e nem vazio")
    String id;
    @NotEmpty(message = "O campo idPauta não pode ser nulo e nem vazio")
    String idPauta;
    @NotEmpty(message = "O campo idEleitor não pode ser nulo e nem vazio")
    String idEleitor;
    @NotNull
    Boolean aprovacao;
}
