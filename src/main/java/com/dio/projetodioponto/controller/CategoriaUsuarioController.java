package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.CategoriaUsuario;
import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.service.CategoriaUsuarioService;
import com.dio.projetodioponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CategoriaUsuario")
public class CategoriaUsuarioController {
    @Autowired
    public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
        this.categoriaUsuarioService = categoriaUsuarioService;
    }

    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.create(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> list(){
        return  categoriaUsuarioService.list();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaUsuario> listById(@PathVariable("idCategoria") long idCategoria) throws Exception {
        return ResponseEntity.ok(categoriaUsuarioService.listById(idCategoria).orElseThrow(()-> new Exception("Categoria não encontrada")));
    }

    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.update(categoriaUsuario);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity deleteById(@PathVariable("idCategoria") Long idCategoria) throws Exception {
        categoriaUsuarioService.deleteById(idCategoria);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
