package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.Ocorrencia;
import com.dio.projetodioponto.repository.OcorrenciaRepository;
import com.dio.projetodioponto.service.JornadaService;
import com.dio.projetodioponto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia create(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.create(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> list(){
        return  ocorrenciaService.list();
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> listById(@PathVariable("idOcorrencia") long idOcorrencia) throws Exception {
        return ResponseEntity.ok(ocorrenciaService.listById(idOcorrencia).orElseThrow(()-> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public Ocorrencia update(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity deleteById(@PathVariable("idOcorrencia") Long idOcorrencia) throws Exception {
        ocorrenciaService.deleteById(idOcorrencia);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
