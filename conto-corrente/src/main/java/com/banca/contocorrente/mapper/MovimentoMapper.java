package com.banca.contocorrente.mapper;

import com.banca.contocorrente.DTO.MovimentoRequestDTO;
import com.banca.contocorrente.DTO.MovimentoResponseDTO;
import com.banca.contocorrente.entity.Movimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimentoMapper {

    @Mapping(target = "conto", ignore = true)
    @Mapping(target = "utente", ignore = true)
    Movimento toEntity(MovimentoRequestDTO movimentoRequestDTO);

    // ✨ Qui usiamo il punto per navigare tra gli oggetti
    @Mapping(target = "idUtente", source = "utente.idUtente")
    @Mapping(target = "numeroConto", source = "conto.numeroConto")
    @Mapping(target = "saldoResiduo", source = "conto.saldo")
    MovimentoResponseDTO toDTO(Movimento movimento);
}
