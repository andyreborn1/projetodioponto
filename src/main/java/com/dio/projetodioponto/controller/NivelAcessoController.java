package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.NivelAcesso;
import com.dio.projetodioponto.service.JornadaService;
import com.dio.projetodioponto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NivelAcesso")
public class NivelAcessoController {
    @Autowired
    public NivelAcessoController(NivelAcessoService nivelAcessoService) {
        this.nivelAcessoService = nivelAcessoService;
    }

    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso create(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.create(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> list(){
        return  nivelAcessoService.list();
    }

    @GetMapping("/{idNivel}")
    public ResponseEntity<NivelAcesso> listById(@PathVariable("idNivel") long idNivel) throws Exception {
        return ResponseEntity.ok(nivelAcessoService.listById(idNivel).orElseThrow(()-> new Exception("Nível de acesso não encontrada")));
    }

    @PutMapping
    public NivelAcesso update(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{idNivel}")
    public ResponseEntity deleteById(@PathVariable("idNivel") Long idNivel) throws Exception {
        nivelAcessoService.deleteById(idNivel);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
