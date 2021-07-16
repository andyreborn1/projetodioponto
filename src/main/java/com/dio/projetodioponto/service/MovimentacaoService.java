package com.dio.projetodioponto.service;

import com.dio.projetodioponto.model.Movimentacao;
import com.dio.projetodioponto.model.Usuario;
import com.dio.projetodioponto.repository.MovimentacaoRepository;
import com.dio.projetodioponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRepository movimentacaoRepository;
    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao create(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> list(){
        return movimentacaoRepository.findAll();
    }

    public void deleteById(Long idMovimentacao) {
        movimentacaoRepository.deleteById(idMovimentacao);
    }

    public Optional<Movimentacao> listById(long idMovimentacao) {
        return movimentacaoRepository.findById(idMovimentacao);
    }

    public Movimentacao update(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }
}