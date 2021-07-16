package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    public void deleteById(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public Optional<Usuario> listById(long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Usuario update(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}