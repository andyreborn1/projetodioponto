package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    JornadaRepository jornadaRepository;
    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho create(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> list(){
        return jornadaRepository.findAll();
    }

    public void deleteById(Long idJornada) {
        jornadaRepository.deleteById(idJornada);
    }

    public Optional<JornadaTrabalho> listById(long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }
}