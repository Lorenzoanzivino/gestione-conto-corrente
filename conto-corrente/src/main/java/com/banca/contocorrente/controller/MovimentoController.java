package com.banca.contocorrente.controller;

import com.banca.contocorrente.DTO.MovimentoRequestDTO;
import com.banca.contocorrente.DTO.MovimentoResponseDTO;
import com.banca.contocorrente.service.MovimentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimenti")
public class MovimentoController {

    private MovimentoService movimentoService;

    public MovimentoController(MovimentoService movimentoService) {
        this.movimentoService = movimentoService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public MovimentoResponseDTO scegliMovimento(@RequestBody MovimentoRequestDTO movimentoRequestDTO){
        return movimentoService.movimento(movimentoRequestDTO);
    }
}
