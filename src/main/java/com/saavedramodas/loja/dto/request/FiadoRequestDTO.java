package com.saavedramodas.loja.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class FiadoRequestDTO {

    private String nomeCliente;

    private BigDecimal valor;

    private LocalDate dataPegou;

    private LocalDate dataVencimento;

    private String descricao;
}