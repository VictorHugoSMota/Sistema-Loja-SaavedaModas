package com.saavedramodas.loja.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter

public class LancamentoRequestDTO {

    private BigDecimal valor;

    private LocalDate data;

    private Long canalRecebimentoId;
}