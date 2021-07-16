package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.model.Movimentacao;
import com.dio.projetodioponto.service.JornadaService;
import com.dio.projetodioponto.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.create(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> list(){
        return  movimentacaoService.list();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> listById(@PathVariable("idMovimentacao") long idMovimentacao) throws Exception {
        return ResponseEntity.ok(movimentacaoService.listById(idMovimentacao).orElseThrow(()-> new Exception("Movimentação não encontrada")));
    }

    @PutMapping
    public Movimentacao update(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteById(@PathVariable("idJornada") Long idJornada) throws Exception {
        movimentacaoService.deleteById(idJornada);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
