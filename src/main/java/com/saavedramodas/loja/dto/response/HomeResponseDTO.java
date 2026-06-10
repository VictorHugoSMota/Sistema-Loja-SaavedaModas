package com.saavedramodas.loja.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class HomeResponseDTO {

    private LocalDate data;

    private BigDecimal faturamentoDia;

}
