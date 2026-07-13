package com.saavedramodas.loja.dto.response;

import com.saavedramodas.loja.domain.enums.StatusFiado;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class FiadoResponseDTO {

    private Long id;

    private String nomeCliente;

    private BigDecimal valor;

    private LocalDate dataPegou;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    private String descricao;

    private StatusFiado status;
}