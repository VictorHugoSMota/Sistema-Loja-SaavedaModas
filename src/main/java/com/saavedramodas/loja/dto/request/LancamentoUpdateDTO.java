package com.saavedramodas.loja.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LancamentoUpdateDTO {

    private BigDecimal valor;

    private LocalDate data;

    private Long canalRecebimentoId;
}