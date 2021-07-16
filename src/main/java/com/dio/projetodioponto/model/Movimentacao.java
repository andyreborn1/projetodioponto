package com.dio.projetodioponto.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

    @AllArgsConstructor
    @EqualsAndHashCode
    @NoArgsConstructor
    @Embeddable
    public class MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    };

    @Id
    @EmbeddedId
    private MovimentacaoId id;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;
    @ManyToOne
    private Ocorrencia ocorrencia;
    @ManyToOne
    private Calendario calendario;
}