package com.banca.contocorrente.DTO;

import com.banca.contocorrente.entity.Movimento;

import java.time.LocalDate;

public record MovimentoResponseDTO(
        int idMovimento,
        Movimento.TipoMovimento tipo,
        LocalDate data,
        double importo,
        int idUtente,
        int numeroConto,
        double saldoResiduo
) {}
