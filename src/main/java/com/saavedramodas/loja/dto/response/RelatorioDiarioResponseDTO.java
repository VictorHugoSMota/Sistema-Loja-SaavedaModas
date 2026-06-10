package com.saavedramodas.loja.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RelatorioDiarioResponseDTO {

    private String canalRecebimento;

    private BigDecimal valor;
}
