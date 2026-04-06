package com.banca.contocorrente.mapper;

import com.banca.contocorrente.DTO.ContoRequestDTO;
import com.banca.contocorrente.DTO.ContoResponseDTO;
import com.banca.contocorrente.entity.ContoCorrente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContoCorrenteMapper {

    // Da DTO di apertura a Entity
    @Mapping(target = "saldo", source = "depositoIniziale")
    @Mapping(target = "proprietari", ignore = true)
    @Mapping(target = "numeroConto", ignore = true)
    @Mapping(target = "movimenti", ignore = true)
    ContoCorrente toEntity(ContoRequestDTO contoRequestDTO);

    // Da Entity a DTO di risposta (Qui c'era l'errore!)
    @Mapping(target = "idUtente", expression = "java(conto.getProprietari().get(0).getIdUtente())")
    ContoResponseDTO toDTO(ContoCorrente conto);
}