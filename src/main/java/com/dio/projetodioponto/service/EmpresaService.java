package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.Empresa;
import com.dio.projetodioponto.model.Empresa;
import com.dio.projetodioponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa create(Empresa Empresa){
        return empresaRepository.save(Empresa);
    }

    public List<Empresa> list(){
        return empresaRepository.findAll();
    }

    public void deleteById(Long idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }

    public Optional<Empresa> listById(long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    public Empresa update(Empresa Empresa){
        return empresaRepository.save(Empresa);
    }
}
