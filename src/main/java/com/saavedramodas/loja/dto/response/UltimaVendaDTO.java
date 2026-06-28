package com.saavedramodas.loja.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class UltimaVendaDTO {

    private LocalDate data;

    private String canal;

    private BigDecimal valor;

}