package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.Calendario;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.CalendarioRepository;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {

    CalendarioRepository calendarioRepository;
    @Autowired
    public CalendarioService(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    public Calendario create(Calendario calendario){
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> list(){
        return calendarioRepository.findAll();
    }

    public void deleteById(Long idCalendario) {
        calendarioRepository.deleteById(idCalendario);
    }

    public Optional<Calendario> listById(long idCalendario) {
        return calendarioRepository.findById(idCalendario);
    }

    public Calendario update(Calendario calendario){
        return calendarioRepository.save(calendario);
    }
}