package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.Ocorrencia;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.OcorrenciaRepository;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    OcorrenciaRepository ocorrenciaRepository;
    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia create(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> list(){
        return ocorrenciaRepository.findAll();
    }

    public void deleteById(Long idOcorrencia) {
        ocorrenciaRepository.deleteById(idOcorrencia);
    }

    public Optional<Ocorrencia> listById(long idOcorrencia) {
        return ocorrenciaRepository.findById(idOcorrencia);
    }

    public Ocorrencia update(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }
}