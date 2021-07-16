package com.dio.projetodioponto.repository;

import com.dio.projetodioponto.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras,Long> {
}
