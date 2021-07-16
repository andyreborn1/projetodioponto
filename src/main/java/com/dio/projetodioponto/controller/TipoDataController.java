package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.TipoData;
import com.dio.projetodioponto.service.JornadaService;
import com.dio.projetodioponto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TipoData")
public class TipoDataController {
    @Autowired
    public TipoDataController(TipoDataService tipoDataService) {
        this.tipoDataService=tipoDataService;
    }

    TipoDataService tipoDataService;

    @PostMapping
    public TipoData create(@RequestBody TipoData tipoData){
        return tipoDataService.create(tipoData);
    }

    @GetMapping
    public List<TipoData> list(){
        return  tipoDataService.list();
    }

    @GetMapping("/{idTipo}")
    public ResponseEntity<TipoData> listById(@PathVariable("idTipo") long idTipo) throws Exception {
        return ResponseEntity.ok(tipoDataService.listById(idTipo).orElseThrow(()-> new Exception("Tipo de dado não encontrada")));
    }

    @PutMapping
    public TipoData update(@RequestBody TipoData tipoData){
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{idTipo}")
    public ResponseEntity deleteById(@PathVariable("idTipo") Long idTipo) throws Exception {
        tipoDataService.deleteById(idTipo);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}