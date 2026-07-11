package com.saavedramodas.loja.domain.entity;

import com.saavedramodas.loja.domain.enums.StatusFiado;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fiado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Fiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nomeCliente;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataPegou;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @Column(length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private StatusFiado status = StatusFiado.PENDENTE;

    @PrePersist
    public void antesDeSalvar() {
        if (status == null) {
            status = StatusFiado.PENDENTE;
        }
    }
}