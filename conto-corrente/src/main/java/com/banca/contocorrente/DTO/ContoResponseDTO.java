package com.banca.contocorrente.DTO;

public record ContoResponseDTO(
        int numeroConto,
        double saldo,
        int idUtente
) {}
