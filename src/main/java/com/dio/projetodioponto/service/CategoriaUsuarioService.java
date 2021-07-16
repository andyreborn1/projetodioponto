package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.CategoriaUsuario;
import com.dio.projetodioponto.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {

    CategoriaUsuarioRepository categoriaUsuarioRepository;
    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository) {
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    public CategoriaUsuario create(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> list(){
        return categoriaUsuarioRepository.findAll();
    }

    public void deleteById(Long idJornada) {
        categoriaUsuarioRepository.deleteById(idJornada);
    }

    public Optional<CategoriaUsuario> listById(long idJornada) {
        return categoriaUsuarioRepository.findById(idJornada);
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

}
