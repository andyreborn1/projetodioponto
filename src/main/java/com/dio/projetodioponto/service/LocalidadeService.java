package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.Localidade;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.LocalidadeRepository;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    LocalidadeRepository localidadeRepository;
    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    public Localidade create(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> list(){
        return localidadeRepository.findAll();
    }

    public void deleteById(Long idLocalidade) {
        localidadeRepository.deleteById(idLocalidade);
    }

    public Optional<Localidade> listById(long idLocalidade) {
        return localidadeRepository.findById(idLocalidade);
    }

    public Localidade update(Localidade localidade){
        return localidadeRepository.save(localidade);
    }
}