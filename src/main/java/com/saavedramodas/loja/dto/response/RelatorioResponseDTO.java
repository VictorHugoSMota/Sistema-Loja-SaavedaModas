package com.saavedramodas.loja.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class RelatorioResponseDTO {

    private List<RelatorioItemDTO> itens;
    private BigDecimal total;

}