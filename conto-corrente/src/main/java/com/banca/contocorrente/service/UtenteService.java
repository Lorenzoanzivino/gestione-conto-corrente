package com.banca.contocorrente.service;

import com.banca.contocorrente.DTO.UtenteRequestDTO;
import com.banca.contocorrente.DTO.UtenteResponseDTO;
import com.banca.contocorrente.entity.Indirizzo;
import com.banca.contocorrente.entity.Utente;
import com.banca.contocorrente.mapper.UtenteMapper;
import com.banca.contocorrente.repository.IndirizzoRepository;
import com.banca.contocorrente.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UtenteService {

    private UtenteRepository utenteRepository;
    private IndirizzoRepository indirizzoRepository;
    private UtenteMapper utenteMapper;

    public UtenteService(UtenteRepository utenteRepository, IndirizzoRepository indirizzoRepository, UtenteMapper utenteMapper) {
        this.utenteRepository = utenteRepository;
        this.indirizzoRepository = indirizzoRepository;
        this.utenteMapper = utenteMapper;
    }

    public UtenteResponseDTO save(UtenteRequestDTO utenteRequestDTO){
        if(utenteRequestDTO == null || utenteRequestDTO.mail() == null || utenteRepository.findByMail(utenteRequestDTO.mail()) != null) {
            throw new RuntimeException("Errore");
        }
        Utente utente = utenteMapper.toEntity(utenteRequestDTO);
        Indirizzo saveIndirizzo = indirizzoRepository.save(utente.getIndirizzo());
        utente.setIndirizzo(saveIndirizzo);

        Utente saveUtente = utenteRepository.save(utente);
        return utenteMapper.toDTO(saveUtente);
    }


}
