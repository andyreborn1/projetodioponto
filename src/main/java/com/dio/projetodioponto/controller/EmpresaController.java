package com.dio.projetodioponto.controller;

import com.dio.projetodioponto.model.Empresa;
import com.dio.projetodioponto.model.JornadaTrabalho;
import com.dio.projetodioponto.service.EmpresaService;
import com.dio.projetodioponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    EmpresaService empresaService;

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.create(empresa);
    }

    @GetMapping
    public List<Empresa> list(){
        return empresaService.list();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> listById(@PathVariable("idEmpresa") long idEmpresa) throws Exception {
        return ResponseEntity.ok(empresaService.listById(idEmpresa).orElseThrow(()-> new Exception("Empresa não encontrada")));
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa empresa){
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity deleteById(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        empresaService.deleteById(idEmpresa);
        return new ResponseEntity<>("Registro deletado", HttpStatus.OK);
    }
}
