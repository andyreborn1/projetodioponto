package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.BancoHoras;
import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.service.BancoHorasService;
import com.dio.projetodioponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BancoHoras")
public class BancoHorasController {
    @Autowired
    public BancoHorasController(BancoHorasService bancoHorasService) {
        this.bancoHorasService = bancoHorasService;
    }

    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras create(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.create(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> list(){
        return bancoHorasService.list();
    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> listById(@PathVariable("idBancoHoras") long idBancoHoras) throws Exception {
        return ResponseEntity.ok(bancoHorasService.listById(idBancoHoras).orElseThrow(()-> new Exception("Banco de Horas não encontrada")));
    }

    @PutMapping
    public BancoHoras update(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.update(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity deleteById(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        bancoHorasService.deleteById(idBancoHoras);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
