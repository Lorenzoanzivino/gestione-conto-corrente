package com.banca.contocorrente.DTO;

import com.banca.contocorrente.entity.Movimento;

public record MovimentoRequestDTO(
        Movimento.TipoMovimento tipo,
        double importo,
        int idUtente,
        int numeroConto
) {}
