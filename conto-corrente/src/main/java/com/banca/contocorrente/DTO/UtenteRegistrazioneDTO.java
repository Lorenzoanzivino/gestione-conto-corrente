package com.banca.contocorrente.DTO;


public record UtenteRegistrazioneDTO(
        String nome,
        String cognome,
        String mail,
        String telefono,
        String via,
        String cap,
        String citta,
        String provincia
) {}
