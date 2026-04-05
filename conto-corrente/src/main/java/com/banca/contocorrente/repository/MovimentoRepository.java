package com.banca.contocorrente.repository;

import com.banca.contocorrente.entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {
}
