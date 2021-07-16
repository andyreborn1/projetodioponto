package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.Calendario;
import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.service.CalendarioService;
import com.dio.projetodioponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    CalendarioService calendarioService;

    @PostMapping
    public Calendario create(@RequestBody Calendario calendario){
        return calendarioService.create(calendario);
    }

    @GetMapping
    public List<Calendario> list(){
        return  calendarioService.list();
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> listById(@PathVariable("idCalendario") long idCalendario) throws Exception {
        return ResponseEntity.ok(calendarioService.listById(idCalendario).orElseThrow(()-> new Exception("Calendario não encontrada")));
    }

    @PutMapping
    public Calendario update(@RequestBody Calendario calendario){
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity deleteById(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        calendarioService.deleteById(idCalendario);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
