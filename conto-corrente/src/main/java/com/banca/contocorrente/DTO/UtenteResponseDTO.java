package com.banca.contocorrente.DTO;

public record UtenteResponseDTO(
        int idUtente,
        String nome,
        String cognome,
        String mail,
        String telefono
) {}
