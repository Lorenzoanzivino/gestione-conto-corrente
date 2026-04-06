package com.banca.contocorrente.mapper;

import com.banca.contocorrente.DTO.UtenteRegistrazioneDTO;
import com.banca.contocorrente.DTO.UtenteResponseDTO;
import com.banca.contocorrente.entity.Utente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    @Mapping(target = "indirizzo.via", source = "via")
    @Mapping(target = "indirizzo.cap", source = "cap")
    @Mapping(target = "indirizzo.citta", source = "citta")
    @Mapping(target = "indirizzo.provincia", source = "provincia")
    Utente toEntity(UtenteRegistrazioneDTO utenteRegistrazioneDTO);
    UtenteResponseDTO toDTO(Utente utente);
}
