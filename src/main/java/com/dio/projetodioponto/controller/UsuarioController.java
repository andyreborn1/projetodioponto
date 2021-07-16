package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.service.JornadaService;
import com.dio.projetodioponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService=usuarioService;
    }

    UsuarioService usuarioService;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @GetMapping
    public List<Usuario> list(){
        return  usuarioService.list();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> listById(@PathVariable("idUsuario") long idUsuario) throws Exception {
        return ResponseEntity.ok(usuarioService.listById(idUsuario).orElseThrow(()-> new Exception("Usuario não encontrada")));
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity deleteById(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        usuarioService.deleteById(idUsuario);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
