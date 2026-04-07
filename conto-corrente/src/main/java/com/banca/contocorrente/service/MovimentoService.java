package com.banca.contocorrente.service;

import com.banca.contocorrente.DTO.*;
import com.banca.contocorrente.entity.ContoCorrente;
import com.banca.contocorrente.entity.Movimento;
import com.banca.contocorrente.entity.Utente;
import com.banca.contocorrente.mapper.MovimentoMapper;
import com.banca.contocorrente.repository.ContoCorrenteRepository;
import com.banca.contocorrente.repository.MovimentoRepository;
import com.banca.contocorrente.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
public class MovimentoService {
    private MovimentoRepository movimentoRepository;
    private MovimentoMapper movimentoMapper;
    private ContoCorrenteRepository contoCorrenteRepository;
    private UtenteRepository utenteRepository;

    public MovimentoService(MovimentoRepository movimentoRepository, MovimentoMapper movimentoMapper, ContoCorrenteRepository contoCorrenteRepository, UtenteRepository utenteRepository) {
        this.movimentoRepository = movimentoRepository;
        this.movimentoMapper = movimentoMapper;
        this.contoCorrenteRepository = contoCorrenteRepository;
        this.utenteRepository = utenteRepository;
    }



    public MovimentoResponseDTO movimento(MovimentoRequestDTO request) {
        // 1. Recupero delle entità dal database
        ContoCorrente conto = contoCorrenteRepository.findById(request.numeroConto())
                .orElseThrow(() -> new RuntimeException("Errore: conto non trovato"));

        Utente utente = utenteRepository.findById(request.idUtente())
                .orElseThrow(() -> new RuntimeException("Errore: utente non trovato"));

        // 2. Controllo sicurezza: l'utente è un proprietario?
        if (!conto.getProprietari().contains(utente)) {
            throw new RuntimeException("Errore: utente non autorizzato");
        }

        // 3. Calcolo del nuovo saldo
        if (request.tipo() == Movimento.TipoMovimento.PRELIEVO) {
            if (conto.getSaldo() < request.importo()) {
                throw new RuntimeException("Errore: Saldo non sufficiente");
            }
            conto.setSaldo(conto.getSaldo() - request.importo());
        } else {
            conto.setSaldo(conto.getSaldo() + request.importo());
        }

        // 4. Preparazione dell'entità Movimento
        // Trasformiamo il DTO in Entity, ma poi riempiamo i campi mancanti
        Movimento movimento = movimentoMapper.toEntity(request);
        movimento.setConto(conto);
        movimento.setUtente(utente);
        movimento.setData(LocalDate.now());

        // 5. Salvataggio
        contoCorrenteRepository.save(conto); // Aggiorniamo il saldo del conto
        Movimento salvato = movimentoRepository.save(movimento); // Registriamo il movimento

        // 6. Risposta al client
        return movimentoMapper.toDTO(salvato);
    }
}

