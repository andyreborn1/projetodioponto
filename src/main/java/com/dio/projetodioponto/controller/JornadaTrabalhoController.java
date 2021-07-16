package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    public JornadaTrabalhoController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho create(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.create(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> list(){
        return  jornadaService.list();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> listById(@PathVariable("idJornada") long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.listById(idJornada).orElseThrow(()-> new Exception("Jornada não encontrada")));
    }

    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteById(@PathVariable("idJornada") Long idJornada) throws Exception {
        jornadaService.deleteById(idJornada);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
