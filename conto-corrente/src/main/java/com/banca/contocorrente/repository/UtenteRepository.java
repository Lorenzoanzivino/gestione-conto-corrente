package com.banca.contocorrente.repository;

import com.banca.contocorrente.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    public Utente findByMail(String mail);
}
