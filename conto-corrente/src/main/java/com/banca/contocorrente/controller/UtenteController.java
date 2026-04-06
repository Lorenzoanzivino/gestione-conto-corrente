package com.banca.contocorrente.controller;

import com.banca.contocorrente.DTO.UtenteRegistrazioneDTO;
import com.banca.contocorrente.DTO.UtenteResponseDTO;
import com.banca.contocorrente.service.UtenteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    private UtenteService utenteService;

    public UtenteController(UtenteService utenteService){
    this.utenteService = utenteService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public UtenteResponseDTO createUtente(@RequestBody UtenteRegistrazioneDTO utenteRegistrazioneDTO){
        return utenteService.save(utenteRegistrazioneDTO);
    }
}
