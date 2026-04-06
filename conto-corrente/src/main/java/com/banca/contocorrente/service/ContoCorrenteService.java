package com.banca.contocorrente.service;

import com.banca.contocorrente.DTO.ContoRequestDTO;
import com.banca.contocorrente.DTO.ContoResponseDTO;
import com.banca.contocorrente.entity.ContoCorrente;
import com.banca.contocorrente.entity.Utente;
import com.banca.contocorrente.mapper.ContoCorrenteMapper;
import com.banca.contocorrente.repository.ContoCorrenteRepository;
import com.banca.contocorrente.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContoCorrenteService {

    private final ContoCorrenteRepository contoCorrenteRepository;
    private final ContoCorrenteMapper contoCorrenteMapper;
    private final UtenteRepository utenteRepository;

    public ContoCorrenteService(ContoCorrenteRepository contoCorrenteRepository,
                                ContoCorrenteMapper contoCorrenteMapper,
                                UtenteRepository utenteRepository) {
        this.contoCorrenteRepository = contoCorrenteRepository;
        this.contoCorrenteMapper = contoCorrenteMapper;
        this.utenteRepository = utenteRepository;
    }

    public ContoResponseDTO apriConto(ContoRequestDTO contoRequestDTO) {
        // Recuperiamo il proprietario dal DB
        Utente proprietario = utenteRepository.findById(contoRequestDTO.idUtente())
                .orElseThrow(() -> new RuntimeException("Errore: utente non trovato"));

        // Mappiamo il DTO in Entity (il saldo viene impostato qui)
        ContoCorrente conto = contoCorrenteMapper.toEntity(contoRequestDTO);

        // Colleghiamo l'utente al conto
        conto.setProprietari(List.of(proprietario));

        // Salviamo il conto
        ContoCorrente saveConto = contoCorrenteRepository.save(conto);

        // Restituiamo la risposta mappata correttamente
        return contoCorrenteMapper.toDTO(saveConto);
    }
}