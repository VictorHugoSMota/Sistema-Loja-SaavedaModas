package com.saavedramodas.loja.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LancamentoResponseDTO {

    private Long id;

    private BigDecimal valor;

    private LocalDate data;

    private String canalRecebimento;
}