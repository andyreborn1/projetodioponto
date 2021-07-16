package com.dio.projetodioponto.repository;

import com.dio.projetodioponto.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario,Long> {
}
