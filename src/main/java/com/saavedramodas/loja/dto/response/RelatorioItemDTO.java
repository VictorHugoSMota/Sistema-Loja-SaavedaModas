package com.saavedramodas.loja.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RelatorioItemDTO {

    private String canalRecebimento;
    private BigDecimal valor;
}