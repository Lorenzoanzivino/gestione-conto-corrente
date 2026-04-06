package com.banca.contocorrente.controller;

import com.banca.contocorrente.DTO.ContoRequestDTO;
import com.banca.contocorrente.DTO.ContoResponseDTO;
import com.banca.contocorrente.service.ContoCorrenteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contiCorrenti")
public class ContoCorrenteController {
    private ContoCorrenteService contoCorrenteService;

    public ContoCorrenteController(ContoCorrenteService contoCorrenteService){
        this.contoCorrenteService = contoCorrenteService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ContoResponseDTO creaConto(@RequestBody ContoRequestDTO contoRequestDTO){
        return contoCorrenteService.apriConto(contoRequestDTO);
    }
}
