package com.dio.projetodioponto.repository;

import com.dio.projetodioponto.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Long> {
}
