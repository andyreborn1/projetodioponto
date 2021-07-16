package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.TipoData;
import com.dio.projetodioponto.repository.JornadaRepository;
import com.dio.projetodioponto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {

    TipoDataRepository tipoDataRepository;
    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public TipoData create(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> list(){
        return tipoDataRepository.findAll();
    }

    public void deleteById(Long idTipoData) {
        tipoDataRepository.deleteById(idTipoData);
    }

    public Optional<TipoData> listById(long idTipoData) {
        return tipoDataRepository.findById(idTipoData);
    }

    public TipoData update(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }
}