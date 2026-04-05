package com.banca.contocorrente.repository;

import com.banca.contocorrente.entity.ContoCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContoCorrenteRepository extends JpaRepository<ContoCorrente, Integer> {
}
