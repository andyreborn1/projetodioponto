package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.Localidade;
import com.dio.projetodioponto.service.JornadaService;
import com.dio.projetodioponto.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    LocalidadeService localidadeService;

    @PostMapping
    public Localidade create(@RequestBody Localidade localidade){
        return localidadeService.create(localidade);
    }

    @GetMapping
    public List<Localidade> list(){
        return  localidadeService.list();
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> listById(@PathVariable("idLocalidade") long idLocalidade) throws Exception {
        return ResponseEntity.ok(localidadeService.listById(idLocalidade).orElseThrow(()-> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public Localidade update(@RequestBody Localidade localidade){
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity deleteById(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        localidadeService.deleteById(idLocalidade);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
