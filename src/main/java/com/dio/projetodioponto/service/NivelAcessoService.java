package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.NivelAcesso;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.NivelAcessoRepository;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    NivelAcessoRepository nivelAcessoRepository;
    @Autowired
    public NivelAcessoService(NivelAcessoRepository nivelAcessoRepository) {
        this.nivelAcessoRepository = nivelAcessoRepository;
    }

    public NivelAcesso create(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> list(){
        return nivelAcessoRepository.findAll();
    }

    public void deleteById(Long idNivelAcesso) {
        nivelAcessoRepository.deleteById(idNivelAcesso);
    }

    public Optional<NivelAcesso> listById(long idNivelAcesso) {
        return nivelAcessoRepository.findById(idNivelAcesso);
    }

    public NivelAcesso update(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }
}