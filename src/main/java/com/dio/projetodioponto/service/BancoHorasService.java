package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.BancoHoras;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.BancoHorasRepository;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;
    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras create(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> list(){
        return bancoHorasRepository.findAll();
    }

    public void deleteById(Long idBancoHoras) {
        bancoHorasRepository.deleteById(idBancoHoras);
    }

    public Optional<BancoHoras> listById(long idBancoHoras) {
        return bancoHorasRepository.findById(idBancoHoras);
    }

    public BancoHoras update(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }
}